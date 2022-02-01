package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;
import android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a.c;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  extends AccessibilityNodeProvider
{
  private static int STR = 267386881;
  private final io.flutter.embedding.engine.c.a SNY;
  public e SNu;
  public final AccessibilityViewEmbedder STS;
  final g STT;
  final Map<Integer, f> STU;
  private final Map<Integer, c> STV;
  public f STW;
  public Integer STX;
  public Integer STY;
  private int STZ;
  public f SUa;
  f SUb;
  public f SUc;
  final List<Integer> SUd;
  int SUe;
  Integer SUf;
  private final io.flutter.embedding.engine.c.a.a SUg;
  private final AccessibilityManager.AccessibilityStateChangeListener SUh;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener SUi;
  private final ContentObserver SUj;
  private final ContentResolver aFp;
  public final AccessibilityManager nC;
  final View rootAccessibilityView;
  
  public a(View paramView, io.flutter.embedding.engine.c.a parama, AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, g paramg)
  {
    this(paramView, parama, paramAccessibilityManager, paramContentResolver, new AccessibilityViewEmbedder(paramView, 65536), paramg);
    AppMethodBeat.i(9750);
    AppMethodBeat.o(9750);
  }
  
  private a(View paramView, io.flutter.embedding.engine.c.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, AccessibilityViewEmbedder paramAccessibilityViewEmbedder, g paramg)
  {
    AppMethodBeat.i(214926);
    this.STU = new HashMap();
    this.STV = new HashMap();
    this.STZ = 0;
    this.SUd = new ArrayList();
    this.SUe = 0;
    this.SUf = Integer.valueOf(0);
    this.SUg = new io.flutter.embedding.engine.c.a.a()
    {
      public final void atq(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void atr(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void bte(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void btf(String paramAnonymousString)
      {
        AppMethodBeat.i(9691);
        AccessibilityEvent localAccessibilityEvent = a.c(a.this);
        localAccessibilityEvent.getText().add(paramAnonymousString);
        a.a(a.this, localAccessibilityEvent);
        AppMethodBeat.o(9691);
      }
      
      public final void updateCustomAccessibilityActions(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9692);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        if (paramAnonymousByteBuffer.hasRemaining())
        {
          a.c localc = locala.atG(paramAnonymousByteBuffer.getInt());
          localc.SUN = paramAnonymousByteBuffer.getInt();
          int i = paramAnonymousByteBuffer.getInt();
          if (i == -1)
          {
            str = null;
            label60:
            localc.label = str;
            i = paramAnonymousByteBuffer.getInt();
            if (i != -1) {
              break label98;
            }
          }
          label98:
          for (String str = null;; str = paramAnonymousArrayOfString[i])
          {
            localc.hint = str;
            break;
            str = paramAnonymousArrayOfString[i];
            break label60;
          }
        }
        AppMethodBeat.o(9692);
      }
      
      public final void updateSemantics(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9693);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        Object localObject1 = new ArrayList();
        while (paramAnonymousByteBuffer.hasRemaining())
        {
          localObject2 = locala.atF(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.SVb))
          {
            if (((a.f)localObject2).a(a.d.SUT)) {
              locala.SUa = ((a.f)localObject2);
            }
            if (((a.f)localObject2).SVz) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.hxv();
        ArrayList localArrayList = new ArrayList();
        if (paramAnonymousByteBuffer != null)
        {
          paramAnonymousArrayOfString = new float[16];
          Matrix.setIdentityM(paramAnonymousArrayOfString, 0);
          if (Build.VERSION.SDK_INT >= 23)
          {
            localObject3 = locala.rootAccessibilityView.getRootWindowInsets();
            if (localObject3 != null)
            {
              if (!locala.SUf.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.SVR = true;
                paramAnonymousByteBuffer.SVP = true;
              }
              locala.SUf = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.SUf.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.kp(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.SUd.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1541;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label1284:
        label1541:
        for (;;)
        {
          break;
          paramAnonymousArrayOfString = paramAnonymousByteBuffer;
          if (paramAnonymousByteBuffer == null)
          {
            paramAnonymousArrayOfString = paramAnonymousByteBuffer;
            if (localArrayList.size() > 0) {
              paramAnonymousArrayOfString = (a.f)localArrayList.get(localArrayList.size() - 1);
            }
          }
          if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.id != locala.SUe))
          {
            locala.SUe = paramAnonymousArrayOfString.id;
            paramAnonymousByteBuffer = locala.mV(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.hxx();
            paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
          }
          locala.SUd.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.SUd.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.STU.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.SVJ = null;
              if ((paramAnonymousArrayOfString.SVq != -1) && (locala.STX != null) && (locala.STS.platformViewOfNode(locala.STX.intValue()) == locala.STT.r(Integer.valueOf(paramAnonymousArrayOfString.SVq))))
              {
                locala.mU(locala.STX.intValue(), 65536);
                locala.STX = null;
              }
              if (locala.STW == paramAnonymousArrayOfString)
              {
                locala.mU(locala.STW.id, 65536);
                locala.STW = null;
              }
              if (locala.SUa == paramAnonymousArrayOfString) {
                locala.SUa = null;
              }
              if (locala.SUc == paramAnonymousArrayOfString) {
                locala.SUc = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.atH(0);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          label724:
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).SVt)) && (!Float.isNaN(((a.f)localObject2).SVE)) && (((a.f)localObject2).SVE != ((a.f)localObject2).SVt))
            {
              i = 1;
              if (i == 0) {
                break label1050;
              }
              paramAnonymousByteBuffer = locala.mV(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).SVt;
              f2 = ((a.f)localObject2).SVu;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).SVu))
              {
                float f4 = 100000.0F;
                f2 = f4;
                f1 = f3;
                if (f3 > 70000.0F)
                {
                  f1 = 70000.0F;
                  f2 = f4;
                }
              }
              if (!Float.isInfinite(((a.f)localObject2).SVv)) {
                break label963;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              label846:
              if ((!((a.f)localObject2).b(a.b.SUu)) && (!((a.f)localObject2).b(a.b.SUv))) {
                break label992;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              label881:
              if (((a.f)localObject2).SVr <= 0) {
                break label1044;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).SVr);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).SVs);
              paramAnonymousArrayOfString = ((a.f)localObject2).SVL.iterator();
              i = 0;
              label921:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label1030;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.SVb)) {
                break label1538;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break label921;
            i = 0;
            break label724;
            label963:
            f2 -= ((a.f)localObject2).SVv;
            f3 = f1 - ((a.f)localObject2).SVv;
            f1 = f2;
            f2 = f3;
            break label846;
            label992:
            if ((!((a.f)localObject2).b(a.b.SUs)) && (!((a.f)localObject2).b(a.b.SUt))) {
              break label881;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label881;
            label1030:
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).SVs + i - 1);
            label1044:
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            label1050:
            if (((a.f)localObject2).a(a.d.SVd))
            {
              if (((((a.f)localObject2).label == null) && (((a.f)localObject2).SVI == null)) || ((((a.f)localObject2).label != null) && (((a.f)localObject2).SVI != null) && (((a.f)localObject2).label.equals(((a.f)localObject2).SVI)))) {
                break label1494;
              }
              i = 1;
              label1112:
              if (i != 0) {
                locala.atH(((a.f)localObject2).id);
              }
            }
            if ((locala.STW != null) && (locala.STW.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.SUQ)) && (((a.f)localObject2).a(a.d.SUQ)))
            {
              paramAnonymousByteBuffer = locala.mV(((a.f)localObject2).id, 4);
              paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            }
            if ((locala.SUa != null) && (locala.SUa.id == ((a.f)localObject2).id) && ((locala.SUb == null) || (locala.SUb.id != locala.SUa.id)))
            {
              locala.SUb = locala.SUa;
              locala.sendAccessibilityEvent(locala.mV(((a.f)localObject2).id, 8));
              if ((locala.SUa == null) || (locala.SUa.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.SUS)) || (!((a.f)localObject2).a(a.d.SUS)) || ((locala.STW != null) && (locala.STW.id != locala.SUa.id))) {
                break label1515;
              }
              if (((a.f)localObject2).SVH == null) {
                break label1517;
              }
              paramAnonymousByteBuffer = ((a.f)localObject2).SVH;
              label1371:
              if (((a.f)localObject2).value == null) {
                break label1524;
              }
            }
            label1494:
            label1515:
            label1517:
            label1524:
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.ae(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).SVC == ((a.f)localObject2).SVo) && (((a.f)localObject2).SVD == ((a.f)localObject2).SVp)) {
                break;
              }
              paramAnonymousByteBuffer = locala.mV(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).SVo);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).SVp);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              break;
              i = 0;
              break label1112;
              if (locala.SUa != null) {
                break label1284;
              }
              locala.SUb = null;
              break label1284;
              break;
              paramAnonymousByteBuffer = "";
              break label1371;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.SUh = new AccessibilityManager.AccessibilityStateChangeListener()
    {
      public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9797);
        if (paramAnonymousBoolean)
        {
          a.e(a.this).a(a.d(a.this));
          a.e(a.this).SNV.setSemanticsEnabled(true);
        }
        for (;;)
        {
          if (a.f(a.this) != null) {
            a.f(a.this).bm(paramAnonymousBoolean, a.g(a.this).isTouchExplorationEnabled());
          }
          AppMethodBeat.o(9797);
          return;
          a.e(a.this).a(null);
          a.e(a.this).SNV.setSemanticsEnabled(false);
        }
      }
    };
    this.SUj = new ContentObserver(new Handler())
    {
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9776);
        onChange(paramAnonymousBoolean, null);
        AppMethodBeat.o(9776);
      }
      
      public final void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        AppMethodBeat.i(9777);
        int i;
        if (Build.VERSION.SDK_INT < 17)
        {
          paramAnonymousUri = null;
          if ((paramAnonymousUri == null) || (!paramAnonymousUri.equals("0"))) {
            break label87;
          }
          i = 1;
          label31:
          if (i == 0) {
            break label92;
          }
          a.a(a.this, a.i(a.this) | a.a.SUo.value);
        }
        for (;;)
        {
          a.j(a.this);
          AppMethodBeat.o(9777);
          return;
          paramAnonymousUri = Settings.Global.getString(a.h(a.this), "transition_animation_scale");
          break;
          label87:
          i = 0;
          break label31;
          label92:
          a.a(a.this, a.i(a.this) & (a.a.SUo.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.SNY = parama;
    this.nC = paramAccessibilityManager;
    this.aFp = paramContentResolver;
    this.STS = paramAccessibilityViewEmbedder;
    this.STT = paramg;
    this.SUh.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.nC.addAccessibilityStateChangeListener(this.SUh);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.SUi = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (paramAnonymousBoolean) {
            a.a(a.this, a.i(a.this) | a.a.SUm.value);
          }
          for (;;)
          {
            a.j(a.this);
            if (a.f(a.this) != null) {
              a.f(a.this).bm(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.k(a.this);
            a.a(a.this, a.i(a.this) & (a.a.SUm.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.SUi.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.nC.addTouchExplorationStateChangeListener(this.SUi);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.SUj.onChange(false);
        paramView = Settings.Global.getUriFor("transition_animation_scale");
        this.aFp.registerContentObserver(paramView, false, this.SUj);
      }
      if (paramg != null) {
        paramg.a(this);
      }
      AppMethodBeat.o(214926);
      return;
      this.SUi = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.SVr > 0) && ((f.a(this.STW, new c() {})) || (!f.a(this.STW, new c() {}))))
    {
      AppMethodBeat.o(9752);
      return true;
    }
    AppMethodBeat.o(9752);
    return false;
  }
  
  @TargetApi(18)
  private boolean a(f paramf, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(9755);
    int i = paramBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    boolean bool = paramBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    switch (i)
    {
    }
    do
    {
      do
      {
        AppMethodBeat.o(9755);
        return false;
        if ((paramBoolean) && (paramf.a(b.SUz)))
        {
          this.SNY.dispatchSemanticsAction(paramInt, b.SUz, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.SUA)));
      this.SNY.dispatchSemanticsAction(paramInt, b.SUA, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.SUK)))
      {
        this.SNY.dispatchSemanticsAction(paramInt, b.SUK, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.SUL)));
    this.SNY.dispatchSemanticsAction(paramInt, b.SUL, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void aH(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.STU.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = hxv().r(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.SUc)
    {
      if (localf != null) {
        mU(localf.id, 128);
      }
      if (this.SUc != null) {
        mU(this.SUc.id, 256);
      }
      this.SUc = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void hxw()
  {
    AppMethodBeat.i(9761);
    if (this.SUc != null)
    {
      mU(this.SUc.id, 256);
      this.SUc = null;
    }
    AppMethodBeat.o(9761);
  }
  
  public final boolean aE(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.nC.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.STU.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = hxv().r(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if ((localf != null) && (localf.SVq != -1))
    {
      boolean bool = this.STS.onAccessibilityHoverEvent(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      aH(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      hxw();
    }
    new StringBuilder("unexpected accessibility hover event: ").append(paramMotionEvent);
    AppMethodBeat.o(9760);
    return false;
  }
  
  final AccessibilityEvent ae(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = mV(paramInt, 16);
    localAccessibilityEvent.setBeforeText(paramString1);
    localAccessibilityEvent.getText().add(paramString2);
    paramInt = 0;
    while ((paramInt < paramString1.length()) && (paramInt < paramString2.length()) && (paramString1.charAt(paramInt) == paramString2.charAt(paramInt))) {
      paramInt += 1;
    }
    if ((paramInt >= paramString1.length()) && (paramInt >= paramString2.length()))
    {
      AppMethodBeat.o(9763);
      return null;
    }
    localAccessibilityEvent.setFromIndex(paramInt);
    int j = paramString1.length() - 1;
    int i = paramString2.length() - 1;
    while ((j >= paramInt) && (i >= paramInt) && (paramString1.charAt(j) == paramString2.charAt(i)))
    {
      j -= 1;
      i -= 1;
    }
    localAccessibilityEvent.setRemovedCount(j - paramInt + 1);
    localAccessibilityEvent.setAddedCount(i - paramInt + 1);
    AppMethodBeat.o(9763);
    return localAccessibilityEvent;
  }
  
  final f atF(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.STU.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.STU.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  final c atG(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.STV.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.resourceId = (STR + paramInt);
      this.STV.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  final void atH(int paramInt)
  {
    AppMethodBeat.i(214927);
    AccessibilityEvent localAccessibilityEvent = mV(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(214927);
  }
  
  @SuppressLint({"NewApi"})
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    if (paramInt >= 65536)
    {
      localObject1 = this.STS.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.STU.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject1 = (f)this.STU.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((f)localObject1).SVq != -1)
    {
      localObject2 = this.STT.r(Integer.valueOf(((f)localObject1).SVq));
      localObject3 = ((f)localObject1).SVT;
      localObject1 = this.STS.getRootNode((View)localObject2, ((f)localObject1).id, (Rect)localObject3);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject2 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, paramInt);
    if (Build.VERSION.SDK_INT >= 18) {
      ((AccessibilityNodeInfo)localObject2).setViewIdResourceName("");
    }
    ((AccessibilityNodeInfo)localObject2).setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    ((AccessibilityNodeInfo)localObject2).setClassName("android.view.View");
    ((AccessibilityNodeInfo)localObject2).setSource(this.rootAccessibilityView, paramInt);
    boolean bool1;
    if (!((f)localObject1).a(d.SUZ)) {
      if (((f)localObject1).a(d.SVi))
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setFocusable(bool1);
        if (this.SUa != null)
        {
          if (this.SUa.id != paramInt) {
            break label1636;
          }
          bool1 = true;
          label297:
          ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
        }
        if (this.STW != null)
        {
          if (this.STW.id != paramInt) {
            break label1642;
          }
          bool1 = true;
          label325:
          ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
        }
        if (((f)localObject1).a(d.SUS))
        {
          ((AccessibilityNodeInfo)localObject2).setPassword(((f)localObject1).a(d.SUY));
          if (!((f)localObject1).a(d.SVh)) {
            ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
          }
          if (Build.VERSION.SDK_INT >= 18)
          {
            if (((f)localObject1).a(d.SVh)) {
              break label1648;
            }
            bool1 = true;
            label397:
            ((AccessibilityNodeInfo)localObject2).setEditable(bool1);
            if ((((f)localObject1).SVo != -1) && (((f)localObject1).SVp != -1)) {
              ((AccessibilityNodeInfo)localObject2).setTextSelection(((f)localObject1).SVo, ((f)localObject1).SVp);
            }
            if ((Build.VERSION.SDK_INT > 18) && (this.STW != null) && (this.STW.id == paramInt)) {
              ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
            }
          }
          if (!((f)localObject1).a(b.SUz)) {
            break label1928;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(256);
        }
      }
    }
    label899:
    label1928:
    for (int j = 1;; j = 0)
    {
      if (((f)localObject1).a(b.SUA))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject1).a(b.SUK))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject1).a(b.SUL))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = i | 0x2;
      }
      ((AccessibilityNodeInfo)localObject2).setMovementGranularities(j);
      label593:
      Object localObject4;
      label801:
      label861:
      label1016:
      boolean bool4;
      if ((Build.VERSION.SDK_INT >= 21) && (((f)localObject1).SVm >= 0))
      {
        if (((f)localObject1).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject2).setMaxTextLength(i - ((f)localObject1).SVn + ((f)localObject1).SVm);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (((f)localObject1).a(b.SUC)) {
            ((AccessibilityNodeInfo)localObject2).addAction(131072);
          }
          if (((f)localObject1).a(b.SUD)) {
            ((AccessibilityNodeInfo)localObject2).addAction(16384);
          }
          if (((f)localObject1).a(b.SUE)) {
            ((AccessibilityNodeInfo)localObject2).addAction(65536);
          }
          if (((f)localObject1).a(b.SUF)) {
            ((AccessibilityNodeInfo)localObject2).addAction(32768);
          }
        }
        if ((((f)localObject1).a(d.SUR)) || (((f)localObject1).a(d.SVj))) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
        }
        if (((f)localObject1).a(d.SVc)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (((f)localObject1).a(b.SUJ)))
        {
          ((AccessibilityNodeInfo)localObject2).setDismissable(true);
          ((AccessibilityNodeInfo)localObject2).addAction(1048576);
        }
        if (((f)localObject1).SVJ == null) {
          break label1666;
        }
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView, ((f)localObject1).SVJ.id);
        localObject3 = ((f)localObject1).SVT;
        if (((f)localObject1).SVJ == null) {
          break label1678;
        }
        localObject4 = ((f)localObject1).SVJ.SVT;
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
        if ((((f)localObject1).a(d.SUU)) && (!((f)localObject1).a(d.SUV))) {
          break label1688;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
        if (((f)localObject1).a(b.SUq))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).SVN == null)) {
            break label1694;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject1).SVN.hint));
          ((AccessibilityNodeInfo)localObject2).setClickable(true);
        }
        label961:
        if (((f)localObject1).a(b.SUr))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).SVO == null)) {
            break label1710;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject1).SVO.hint));
          ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        }
        if ((((f)localObject1).a(b.SUs)) || (((f)localObject1).a(b.SUu)) || (((f)localObject1).a(b.SUt)) || (((f)localObject1).a(b.SUv)))
        {
          ((AccessibilityNodeInfo)localObject2).setScrollable(true);
          if (((f)localObject1).a(d.SVg))
          {
            if ((!((f)localObject1).a(b.SUs)) && (!((f)localObject1).a(b.SUt))) {
              break label1737;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject1))) {
              break label1726;
            }
            ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject1).SVr, false));
          }
          label1131:
          if ((((f)localObject1).a(b.SUs)) || (((f)localObject1).a(b.SUu))) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if ((((f)localObject1).a(b.SUt)) || (((f)localObject1).a(b.SUv))) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(b.SUw)) || (((f)localObject1).a(b.SUx)))
        {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
          if (((f)localObject1).a(b.SUw)) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if (((f)localObject1).a(b.SUx)) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(d.SVd)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
        }
        if (!((f)localObject1).a(d.SUS)) {
          break label1783;
        }
        ((AccessibilityNodeInfo)localObject2).setText(f.b((f)localObject1));
        label1305:
        boolean bool3 = ((f)localObject1).a(d.SUO);
        bool4 = ((f)localObject1).a(d.SVe);
        if (!bool3)
        {
          bool1 = bool2;
          if (!bool4) {}
        }
        else
        {
          bool1 = true;
        }
        ((AccessibilityNodeInfo)localObject2).setCheckable(bool1);
        if (!bool3) {
          break label1818;
        }
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.SUP));
        if (!((f)localObject1).a(d.SUW)) {
          break label1807;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
        label1386:
        ((AccessibilityNodeInfo)localObject2).setSelected(((f)localObject1).a(d.SUQ));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject2).setHeading(((f)localObject1).a(d.SUX));
        }
        if ((this.STW == null) || (this.STW.id != paramInt)) {
          break label1847;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).SVM == null)) {
          break label1857;
        }
        localObject3 = ((f)localObject1).SVM.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).resourceId, ((c)localObject4).label));
        }
        if (((((b.SUt.value | b.SUs.value | b.SUu.value | b.SUv.value) ^ 0xFFFFFFFF) & ((f)localObject1).SVl) != 0) || (((f)localObject1).flags != 0) || ((((f)localObject1).label != null) && (!((f)localObject1).label.isEmpty())) || ((((f)localObject1).value != null) && (!((f)localObject1).value.isEmpty())) || ((((f)localObject1).hint != null) && (!((f)localObject1).hint.isEmpty())))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        label1636:
        bool1 = false;
        break label297;
        label1642:
        bool1 = false;
        break label325;
        label1648:
        bool1 = false;
        break label397;
        i = ((f)localObject1).value.length();
        break label593;
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView);
        break label801;
        label1678:
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject3);
        break label861;
        label1688:
        bool1 = false;
        break label899;
        label1694:
        ((AccessibilityNodeInfo)localObject2).addAction(16);
        ((AccessibilityNodeInfo)localObject2).setClickable(true);
        break label961;
        label1710:
        ((AccessibilityNodeInfo)localObject2).addAction(32);
        ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        break label1016;
        label1726:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.HorizontalScrollView");
        break label1131;
        label1737:
        if ((Build.VERSION.SDK_INT > 18) && (a((f)localObject1)))
        {
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject1).SVr, 0, false));
          break label1131;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ScrollView");
        break label1131;
        label1783:
        if (((f)localObject1).a(d.SUZ)) {
          break label1305;
        }
        ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
        break label1305;
        label1807:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.CheckBox");
        break label1386;
        label1818:
        if (!bool4) {
          break label1386;
        }
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.SVf));
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
        break label1386;
        label1847:
        ((AccessibilityNodeInfo)localObject2).addAction(64);
      }
      label1857:
      localObject1 = ((f)localObject1).SVK.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        if (!((f)localObject3).a(d.SVb)) {
          ((AccessibilityNodeInfo)localObject2).addChild(this.rootAccessibilityView, ((f)localObject3).id);
        }
      }
      AppMethodBeat.o(9753);
      return localObject2;
    }
  }
  
  public final AccessibilityNodeInfo findFocus(int paramInt)
  {
    AppMethodBeat.i(9756);
    switch (paramInt)
    {
    }
    do
    {
      AppMethodBeat.o(9756);
      return null;
      if (this.SUa != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.SUa.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.STY != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.STY.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.STW != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.STW.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.STX == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.STX.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final f hxv()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.STU.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
  }
  
  final void mU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.nC.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(mV(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent mV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9766);
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
    localAccessibilityEvent.setSource(this.rootAccessibilityView, paramInt1);
    AppMethodBeat.o(9766);
    return localAccessibilityEvent;
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    int i = 0;
    AppMethodBeat.i(9754);
    boolean bool;
    if (paramInt1 >= 65536)
    {
      bool = this.STS.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.STX = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    f localf = (f)this.STU.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = STR;
      paramBundle = (c)this.STV.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.SNY.dispatchSemanticsAction(paramInt1, b.SUI, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUq);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUr);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (localf.a(b.SUu)) {
        this.SNY.dispatchSemanticsAction(paramInt1, b.SUu);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.SUs))
        {
          this.SNY.dispatchSemanticsAction(paramInt1, b.SUs);
        }
        else
        {
          if (!localf.a(b.SUw)) {
            break;
          }
          localf.value = localf.SVw;
          mU(paramInt1, 4);
          this.SNY.dispatchSemanticsAction(paramInt1, b.SUw);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (localf.a(b.SUv)) {
        this.SNY.dispatchSemanticsAction(paramInt1, b.SUv);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.SUt))
        {
          this.SNY.dispatchSemanticsAction(paramInt1, b.SUt);
        }
        else
        {
          if (!localf.a(b.SUx)) {
            break;
          }
          localf.value = localf.SVx;
          mU(paramInt1, 4);
          this.SNY.dispatchSemanticsAction(paramInt1, b.SUx);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 512: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = a(localf, paramInt1, paramBundle, false);
      AppMethodBeat.o(9754);
      return bool;
    case 256: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      bool = a(localf, paramInt1, paramBundle, true);
      AppMethodBeat.o(9754);
      return bool;
    case 128: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUH);
      mU(paramInt1, 65536);
      this.STW = null;
      this.STX = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUG);
      mU(paramInt1, 32768);
      if (this.STW == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.STW = localf;
      if ((localf.a(b.SUw)) || (localf.a(b.SUx))) {
        mU(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUy);
      AppMethodBeat.o(9754);
      return true;
    case 131072: 
      if (Build.VERSION.SDK_INT < 18)
      {
        AppMethodBeat.o(9754);
        return false;
      }
      HashMap localHashMap = new HashMap();
      paramInt2 = i;
      if (paramBundle != null)
      {
        paramInt2 = i;
        if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT"))
        {
          paramInt2 = i;
          if (paramBundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
            paramInt2 = 1;
          }
        }
      }
      if (paramInt2 != 0)
      {
        localHashMap.put("base", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
        localHashMap.put("extent", Integer.valueOf(paramBundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
      }
      for (;;)
      {
        this.SNY.dispatchSemanticsAction(paramInt1, b.SUC, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localf.SVp));
        localHashMap.put("extent", Integer.valueOf(localf.SVp));
      }
    case 16384: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUD);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUE);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUF);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.SNY.dispatchSemanticsAction(paramInt1, b.SUJ);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    if (this.STT != null) {
      this.STT.hxq();
    }
    this.SNu = null;
    this.nC.removeAccessibilityStateChangeListener(this.SUh);
    if (Build.VERSION.SDK_INT >= 19) {
      this.nC.removeTouchExplorationStateChangeListener(this.SUi);
    }
    this.aFp.unregisterContentObserver(this.SUj);
    this.SNY.a(null);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.STU.clear();
    if (this.STW != null) {
      mU(this.STW.id, 65536);
    }
    this.STW = null;
    this.SUc = null;
    atH(0);
    AppMethodBeat.o(9767);
  }
  
  final void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.nC.isEnabled())
    {
      AppMethodBeat.o(9765);
      return;
    }
    this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, paramAccessibilityEvent);
    AppMethodBeat.o(9765);
  }
  
  public static enum b
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(9783);
      SUq = new b("TAP", 0, 1);
      SUr = new b("LONG_PRESS", 1, 2);
      SUs = new b("SCROLL_LEFT", 2, 4);
      SUt = new b("SCROLL_RIGHT", 3, 8);
      SUu = new b("SCROLL_UP", 4, 16);
      SUv = new b("SCROLL_DOWN", 5, 32);
      SUw = new b("INCREASE", 6, 64);
      SUx = new b("DECREASE", 7, 128);
      SUy = new b("SHOW_ON_SCREEN", 8, 256);
      SUz = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      SUA = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      SUC = new b("SET_SELECTION", 11, 2048);
      SUD = new b("COPY", 12, 4096);
      SUE = new b("CUT", 13, 8192);
      SUF = new b("PASTE", 14, 16384);
      SUG = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      SUH = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      SUI = new b("CUSTOM_ACTION", 17, 131072);
      SUJ = new b("DISMISS", 18, 262144);
      SUK = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      SUL = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      SUM = new b[] { SUq, SUr, SUs, SUt, SUu, SUv, SUw, SUx, SUy, SUz, SUA, SUC, SUD, SUE, SUF, SUG, SUH, SUI, SUJ, SUK, SUL };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int SUN = -1;
    String hint;
    int id = -1;
    String label;
    int resourceId = -1;
  }
  
  static enum d
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(9679);
      SUO = new d("HAS_CHECKED_STATE", 0, 1);
      SUP = new d("IS_CHECKED", 1, 2);
      SUQ = new d("IS_SELECTED", 2, 4);
      SUR = new d("IS_BUTTON", 3, 8);
      SUS = new d("IS_TEXT_FIELD", 4, 16);
      SUT = new d("IS_FOCUSED", 5, 32);
      SUU = new d("HAS_ENABLED_STATE", 6, 64);
      SUV = new d("IS_ENABLED", 7, 128);
      SUW = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      SUX = new d("IS_HEADER", 9, 512);
      SUY = new d("IS_OBSCURED", 10, 1024);
      SUZ = new d("SCOPES_ROUTE", 11, 2048);
      SVa = new d("NAMES_ROUTE", 12, 4096);
      SVb = new d("IS_HIDDEN", 13, 8192);
      SVc = new d("IS_IMAGE", 14, 16384);
      SVd = new d("IS_LIVE_REGION", 15, 32768);
      SVe = new d("HAS_TOGGLED_STATE", 16, 65536);
      SVf = new d("IS_TOGGLED", 17, 131072);
      SVg = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      SVh = new d("IS_READ_ONLY", 19, 1048576);
      SVi = new d("IS_FOCUSABLE", 20, 2097152);
      SVj = new d("IS_LINK", 21, 4194304);
      SVk = new d[] { SUO, SUP, SUQ, SUR, SUS, SUT, SUU, SUV, SUW, SUX, SUY, SUZ, SVa, SVb, SVc, SVd, SVe, SVf, SVg, SVh, SVi, SVj };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface e
  {
    public abstract void bm(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  static final class f
  {
    final a SNs;
    private int SVA;
    private int SVB;
    int SVC;
    int SVD;
    float SVE;
    private float SVF;
    private float SVG;
    String SVH;
    String SVI;
    f SVJ;
    List<f> SVK;
    List<f> SVL;
    List<a.c> SVM;
    a.c SVN;
    a.c SVO;
    boolean SVP;
    private float[] SVQ;
    boolean SVR;
    private float[] SVS;
    Rect SVT;
    int SVl;
    int SVm;
    int SVn;
    int SVo;
    int SVp;
    int SVq;
    int SVr;
    int SVs;
    float SVt;
    float SVu;
    float SVv;
    String SVw;
    String SVx;
    private a.g SVy;
    boolean SVz;
    private float bottom;
    int flags;
    String hint;
    int id;
    String label;
    private float left;
    private float right;
    private float top;
    private float[] transform;
    String value;
    
    f(a parama)
    {
      AppMethodBeat.i(9803);
      this.id = -1;
      this.SVz = false;
      this.SVK = new ArrayList();
      this.SVL = new ArrayList();
      this.SVP = true;
      this.SVR = true;
      this.SNs = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.SVJ;
        if (paramf != null) {
          if (!paramc.test(paramf)) {}
        }
        for (;;)
        {
          if (paramf == null) {
            break label54;
          }
          AppMethodBeat.o(9802);
          return true;
          paramf = paramf.SVJ;
          break;
          paramf = null;
        }
      }
      label54:
      AppMethodBeat.o(9802);
      return false;
    }
    
    private static void c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
    {
      AppMethodBeat.i(9809);
      Matrix.multiplyMV(paramArrayOfFloat1, 0, paramArrayOfFloat2, 0, paramArrayOfFloat3, 0);
      float f = paramArrayOfFloat1[3];
      paramArrayOfFloat1[0] /= f;
      paramArrayOfFloat1[1] /= f;
      paramArrayOfFloat1[2] /= f;
      paramArrayOfFloat1[3] = 0.0F;
      AppMethodBeat.o(9809);
    }
    
    private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9811);
      paramFloat1 = Math.max(paramFloat1, Math.max(paramFloat2, Math.max(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9811);
      return paramFloat1;
    }
    
    private String hxy()
    {
      int i = 0;
      AppMethodBeat.i(9812);
      Object localObject = new StringBuilder();
      String str1 = this.value;
      String str2 = this.label;
      String str3 = this.hint;
      while (i < 3)
      {
        String str4 = new String[] { str1, str2, str3 }[i];
        if ((str4 != null) && (str4.length() > 0))
        {
          if (((StringBuilder)localObject).length() > 0) {
            ((StringBuilder)localObject).append(", ");
          }
          ((StringBuilder)localObject).append(str4);
        }
        i += 1;
      }
      if (((StringBuilder)localObject).length() > 0)
      {
        localObject = ((StringBuilder)localObject).toString();
        AppMethodBeat.o(9812);
        return localObject;
      }
      AppMethodBeat.o(9812);
      return null;
    }
    
    private static float t(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.SVz = true;
      this.SVH = this.value;
      this.SVI = this.label;
      this.SVA = this.flags;
      this.SVB = this.SVl;
      this.SVC = this.SVo;
      this.SVD = this.SVp;
      this.SVE = this.SVt;
      this.SVF = this.SVu;
      this.SVG = this.SVv;
      this.flags = paramByteBuffer.getInt();
      this.SVl = paramByteBuffer.getInt();
      this.SVm = paramByteBuffer.getInt();
      this.SVn = paramByteBuffer.getInt();
      this.SVo = paramByteBuffer.getInt();
      this.SVp = paramByteBuffer.getInt();
      this.SVq = paramByteBuffer.getInt();
      this.SVr = paramByteBuffer.getInt();
      this.SVs = paramByteBuffer.getInt();
      this.SVt = paramByteBuffer.getFloat();
      this.SVu = paramByteBuffer.getFloat();
      this.SVv = paramByteBuffer.getFloat();
      int i = paramByteBuffer.getInt();
      String str;
      if (i == -1)
      {
        str = null;
        this.label = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label363;
        }
        str = null;
        label211:
        this.value = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label371;
        }
        str = null;
        label230:
        this.SVw = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.SVx = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.SVy = a.g.atI(paramByteBuffer.getInt());
        this.left = paramByteBuffer.getFloat();
        this.top = paramByteBuffer.getFloat();
        this.right = paramByteBuffer.getFloat();
        this.bottom = paramByteBuffer.getFloat();
        if (this.transform == null) {
          this.transform = new float[16];
        }
        i = 0;
        while (i < 16)
        {
          this.transform[i] = paramByteBuffer.getFloat();
          i += 1;
        }
        str = paramArrayOfString[i];
        break;
        label363:
        str = paramArrayOfString[i];
        break label211;
        label371:
        str = paramArrayOfString[i];
        break label230;
        label379:
        str = paramArrayOfString[i];
        break label249;
      }
      this.SVP = true;
      this.SVR = true;
      int j = paramByteBuffer.getInt();
      this.SVK.clear();
      this.SVL.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.SNs, paramByteBuffer.getInt());
        paramArrayOfString.SVJ = this;
        this.SVK.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.SNs, paramByteBuffer.getInt());
        paramArrayOfString.SVJ = this;
        this.SVL.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.SVM = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.SVM == null)
      {
        this.SVM = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = a.c(this.SNs, paramByteBuffer.getInt());
        if (paramArrayOfString.SUN != a.b.SUq.value) {
          break label625;
        }
        this.SVN = paramArrayOfString;
      }
      for (;;)
      {
        this.SVM.add(paramArrayOfString);
        i += 1;
        break label559;
        this.SVM.clear();
        break;
        label625:
        if (paramArrayOfString.SUN == a.b.SUr.value) {
          this.SVO = paramArrayOfString;
        } else {
          this.SVM.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.SVR) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.SVS == null) {
          this.SVS = new float[16];
        }
        Matrix.multiplyMM(this.SVS, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        c(arrayOfFloat1, this.SVS, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        c(arrayOfFloat2, this.SVS, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        c(arrayOfFloat3, this.SVS, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        c(arrayOfFloat4, this.SVS, paramArrayOfFloat);
        if (this.SVT == null) {
          this.SVT = new Rect();
        }
        this.SVT.set(Math.round(t(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(t(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(d(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(d(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.SVR = false;
      }
      paramArrayOfFloat = this.SVK.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.SVS, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.SVl & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.SVB & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.SVA & paramd.value) != 0;
    }
    
    final String hxx()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.SVa)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.SVK.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).hxx();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void kp(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.SUZ)) {
        paramList.add(this);
      }
      Iterator localIterator = this.SVK.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).kp(paramList);
      }
      AppMethodBeat.o(9806);
    }
    
    final f r(float[] paramArrayOfFloat)
    {
      AppMethodBeat.i(9805);
      float f2 = paramArrayOfFloat[3];
      float f1 = paramArrayOfFloat[0] / f2;
      f2 = paramArrayOfFloat[1] / f2;
      if ((f1 < this.left) || (f1 >= this.right) || (f2 < this.top) || (f2 >= this.bottom))
      {
        AppMethodBeat.o(9805);
        return null;
      }
      float[] arrayOfFloat = new float[4];
      Iterator localIterator = this.SVL.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.SVb))
        {
          if (localf.SVP)
          {
            localf.SVP = false;
            if (localf.SVQ == null) {
              localf.SVQ = new float[16];
            }
            if (!Matrix.invertM(localf.SVQ, 0, localf.transform, 0)) {
              Arrays.fill(localf.SVQ, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.SVQ, 0, paramArrayOfFloat, 0);
          localf = localf.r(arrayOfFloat);
          if (localf != null)
          {
            AppMethodBeat.o(9805);
            return localf;
          }
        }
      }
      AppMethodBeat.o(9805);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     io.flutter.view.a
 * JD-Core Version:    0.7.0.1
 */