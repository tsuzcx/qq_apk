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
import io.flutter.b.c;
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
  private static int KQf = 267386881;
  public e KLa;
  private final io.flutter.embedding.engine.c.a KLm;
  public final AccessibilityViewEmbedder KQg;
  private final g KQh;
  final Map<Integer, f> KQi;
  private final Map<Integer, c> KQj;
  public f KQk;
  public Integer KQl;
  public Integer KQm;
  private int KQn;
  public f KQo;
  f KQp;
  public f KQq;
  final List<Integer> KQr;
  int KQs;
  Integer KQt;
  private final io.flutter.embedding.engine.c.a.a KQu;
  private final AccessibilityManager.AccessibilityStateChangeListener KQv;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener KQw;
  private final ContentObserver KQx;
  private final ContentResolver aDI;
  public final AccessibilityManager lH;
  final View rootAccessibilityView;
  
  public a(View paramView, io.flutter.embedding.engine.c.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, g paramg)
  {
    AppMethodBeat.i(9750);
    this.KQi = new HashMap();
    this.KQj = new HashMap();
    this.KQn = 0;
    this.KQr = new ArrayList();
    this.KQs = 0;
    this.KQt = Integer.valueOf(0);
    this.KQu = new io.flutter.embedding.engine.c.a.a()
    {
      public final void aVJ(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void aVK(String paramAnonymousString)
      {
        AppMethodBeat.i(9691);
        AccessibilityEvent localAccessibilityEvent = a.c(a.this);
        localAccessibilityEvent.getText().add(paramAnonymousString);
        a.a(a.this, localAccessibilityEvent);
        AppMethodBeat.o(9691);
      }
      
      public final void agw(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void agx(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void updateCustomAccessibilityActions(ByteBuffer paramAnonymousByteBuffer, String[] paramAnonymousArrayOfString)
      {
        AppMethodBeat.i(9692);
        paramAnonymousByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        a locala = a.this;
        if (paramAnonymousByteBuffer.hasRemaining())
        {
          a.c localc = locala.agE(paramAnonymousByteBuffer.getInt());
          localc.KRb = paramAnonymousByteBuffer.getInt();
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
          localObject2 = locala.agD(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.KRp))
          {
            if (((a.f)localObject2).a(a.d.KRh)) {
              locala.KQo = ((a.f)localObject2);
            }
            if (((a.f)localObject2).KRN) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.fNR();
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
              if (!locala.KQt.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.KSf = true;
                paramAnonymousByteBuffer.KSd = true;
              }
              locala.KQt = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.KQt.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.iL(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.KQr.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1576;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label650:
        label807:
        label1576:
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
          if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.id != locala.KQs))
          {
            locala.KQs = paramAnonymousArrayOfString.id;
            paramAnonymousByteBuffer = locala.kW(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.fNT();
            paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
          }
          locala.KQr.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.KQr.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.KQi.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.KRX = null;
              if (locala.KQk == paramAnonymousArrayOfString)
              {
                locala.kV(locala.KQk.id, 65536);
                locala.KQk = null;
              }
              if (locala.KQo == paramAnonymousArrayOfString) {
                locala.KQo = null;
              }
              if (locala.KQq == paramAnonymousArrayOfString) {
                locala.KQq = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.agF(0);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).KRH)) && (!Float.isNaN(((a.f)localObject2).KRS)) && (((a.f)localObject2).KRS != ((a.f)localObject2).KRH))
            {
              i = 1;
              if (i == 0) {
                break label976;
              }
              paramAnonymousByteBuffer = locala.kW(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).KRH;
              f2 = ((a.f)localObject2).KRI;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).KRI))
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
              if (!Float.isInfinite(((a.f)localObject2).KRJ)) {
                break label889;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              if ((!((a.f)localObject2).b(a.b.KQJ)) && (!((a.f)localObject2).b(a.b.KQK))) {
                break label918;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              if (((a.f)localObject2).KRF <= 0) {
                break label970;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).KRF);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).KRG);
              paramAnonymousArrayOfString = ((a.f)localObject2).KRZ.iterator();
              i = 0;
              label847:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label956;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.KRp)) {
                break label1573;
              }
              i += 1;
            }
          }
          for (;;)
          {
            break label847;
            i = 0;
            break label650;
            label889:
            f2 -= ((a.f)localObject2).KRJ;
            f3 = f1 - ((a.f)localObject2).KRJ;
            f1 = f2;
            f2 = f3;
            break label772;
            if ((!((a.f)localObject2).b(a.b.KQH)) && (!((a.f)localObject2).b(a.b.KQI))) {
              break label807;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label807;
            label956:
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).KRG + i - 1);
            label970:
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            label976:
            if (((a.f)localObject2).a(a.d.KRr)) {
              if (((a.f)localObject2).label == null)
              {
                paramAnonymousByteBuffer = "";
                label999:
                if (((a.f)localObject2).KRW != null) {
                  break label1416;
                }
                paramAnonymousArrayOfString = "";
                label1011:
                if ((!paramAnonymousByteBuffer.equals(paramAnonymousArrayOfString)) || (!((a.f)localObject2).b(a.d.KRr))) {
                  locala.agF(((a.f)localObject2).id);
                }
                if ((locala.KQk != null) && (locala.KQk.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.KRe)) && (((a.f)localObject2).a(a.d.KRe)))
                {
                  paramAnonymousByteBuffer = locala.kW(((a.f)localObject2).id, 4);
                  paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
                  locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
                }
                if ((locala.KQo == null) || (locala.KQo.id != ((a.f)localObject2).id) || ((locala.KQp != null) && (locala.KQp.id == locala.KQo.id))) {
                  break label1535;
                }
                locala.KQp = locala.KQo;
                locala.sendAccessibilityEvent(locala.kW(((a.f)localObject2).id, 8));
                if ((locala.KQo == null) || (locala.KQo.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.KRg)) || (!((a.f)localObject2).a(a.d.KRg)) || ((locala.KQk != null) && (locala.KQk.id != locala.KQo.id))) {
                  break label1550;
                }
                if (((a.f)localObject2).KRV == null) {
                  break label1552;
                }
                paramAnonymousByteBuffer = ((a.f)localObject2).KRV;
                if (((a.f)localObject2).value == null) {
                  break label1559;
                }
              }
            }
            label1197:
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.Y(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).KRQ == ((a.f)localObject2).KRC) && (((a.f)localObject2).KRR == ((a.f)localObject2).KRD)) {
                break;
              }
              paramAnonymousByteBuffer = locala.kW(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).KRC);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).KRD);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              break;
              paramAnonymousByteBuffer = ((a.f)localObject2).label;
              break label999;
              paramAnonymousArrayOfString = ((a.f)localObject2).label;
              break label1011;
              if (!((a.f)localObject2).a(a.d.KRg)) {
                break label1040;
              }
              if (((((a.f)localObject2).label != null) || (((a.f)localObject2).KRW != null)) && ((((a.f)localObject2).label == null) || (((a.f)localObject2).KRW == null) || (!((a.f)localObject2).label.equals(((a.f)localObject2).KRW)))) {}
              for (i = 1;; i = 0)
              {
                if ((i == 0) || (locala.KQo == null) || (locala.KQo.id != ((a.f)localObject2).id)) {
                  break label1533;
                }
                locala.agF(((a.f)localObject2).id);
                break;
              }
              label1533:
              break label1040;
              label1535:
              if (locala.KQo != null) {
                break label1197;
              }
              locala.KQp = null;
              break label1197;
              break;
              paramAnonymousByteBuffer = "";
              break label1284;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.KQv = new AccessibilityManager.AccessibilityStateChangeListener()
    {
      public final void onAccessibilityStateChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(9797);
        if (paramAnonymousBoolean)
        {
          a.e(a.this).a(a.d(a.this));
          a.e(a.this).KLj.setSemanticsEnabled(true);
        }
        for (;;)
        {
          if (a.f(a.this) != null) {
            a.f(a.this).aV(paramAnonymousBoolean, a.g(a.this).isTouchExplorationEnabled());
          }
          AppMethodBeat.o(9797);
          return;
          a.e(a.this).a(null);
          a.e(a.this).KLj.setSemanticsEnabled(false);
        }
      }
    };
    this.KQx = new ContentObserver(new Handler())
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
          a.a(a.this, a.i(a.this) | a.a.KQD.value);
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
          a.a(a.this, a.i(a.this) & (a.a.KQD.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.KLm = parama;
    this.lH = paramAccessibilityManager;
    this.aDI = paramContentResolver;
    this.KQh = paramg;
    this.KQv.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.lH.addAccessibilityStateChangeListener(this.KQv);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.KQw = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (paramAnonymousBoolean) {
            a.a(a.this, a.i(a.this) | a.a.KQB.value);
          }
          for (;;)
          {
            a.j(a.this);
            if (a.f(a.this) != null) {
              a.f(a.this).aV(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.k(a.this);
            a.a(a.this, a.i(a.this) & (a.a.KQB.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.KQw.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.lH.addTouchExplorationStateChangeListener(this.KQw);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.KQx.onChange(false);
        parama = Settings.Global.getUriFor("transition_animation_scale");
        this.aDI.registerContentObserver(parama, false, this.KQx);
      }
      if (paramg != null) {
        paramg.a(this);
      }
      this.KQg = new AccessibilityViewEmbedder(paramView, 65536);
      AppMethodBeat.o(9750);
      return;
      this.KQw = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.KRF > 0) && ((f.a(this.KQk, new c() {})) || (!f.a(this.KQk, new c() {}))))
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
        if ((paramBoolean) && (paramf.a(b.KQO)))
        {
          this.KLm.dispatchSemanticsAction(paramInt, b.KQO, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.KQP)));
      this.KLm.dispatchSemanticsAction(paramInt, b.KQP, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.KQY)))
      {
        this.KLm.dispatchSemanticsAction(paramInt, b.KQY, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.KQZ)));
    this.KLm.dispatchSemanticsAction(paramInt, b.KQZ, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void aq(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.KQi.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = fNR().r(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.KQq)
    {
      if (localf != null) {
        kV(localf.id, 128);
      }
      if (this.KQq != null) {
        kV(this.KQq.id, 256);
      }
      this.KQq = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void fNS()
  {
    AppMethodBeat.i(9761);
    if (this.KQq != null)
    {
      kV(this.KQq.id, 256);
      this.KQq = null;
    }
    AppMethodBeat.o(9761);
  }
  
  final AccessibilityEvent Y(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = kW(paramInt, 16);
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
  
  final f agD(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.KQi.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.KQi.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  final c agE(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.KQj.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.resourceId = (KQf + paramInt);
      this.KQj.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  final void agF(int paramInt)
  {
    AppMethodBeat.i(192792);
    AccessibilityEvent localAccessibilityEvent = kW(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(192792);
  }
  
  public final boolean an(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.lH.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.KQi.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = fNR().r(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if (localf.KRE != -1)
    {
      boolean bool = this.KQg.onAccessibilityHoverEvent(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      aq(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      fNS();
    }
    new StringBuilder("unexpected accessibility hover event: ").append(paramMotionEvent);
    AppMethodBeat.o(9760);
    return false;
  }
  
  @SuppressLint({"NewApi"})
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(9753);
    if (paramInt >= 65536)
    {
      localObject1 = this.KQg.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.KQi.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject1 = (f)this.KQi.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((f)localObject1).KRE != -1)
    {
      localObject2 = this.KQh.o(Integer.valueOf(((f)localObject1).KRE));
      localObject3 = ((f)localObject1).KSh;
      localObject1 = this.KQg.getRootNode((View)localObject2, ((f)localObject1).id, (Rect)localObject3);
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
    if (!((f)localObject1).a(d.KRn)) {
      if (((f)localObject1).a(d.KRw))
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setFocusable(bool1);
        if (this.KQo != null)
        {
          if (this.KQo.id != paramInt) {
            break label1625;
          }
          bool1 = true;
          label297:
          ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
        }
        if (this.KQk != null)
        {
          if (this.KQk.id != paramInt) {
            break label1631;
          }
          bool1 = true;
          label325:
          ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
        }
        if (((f)localObject1).a(d.KRg))
        {
          ((AccessibilityNodeInfo)localObject2).setPassword(((f)localObject1).a(d.KRm));
          if (!((f)localObject1).a(d.KRv)) {
            ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
          }
          if (Build.VERSION.SDK_INT >= 18)
          {
            if (((f)localObject1).a(d.KRv)) {
              break label1637;
            }
            bool1 = true;
            label397:
            ((AccessibilityNodeInfo)localObject2).setEditable(bool1);
            if ((((f)localObject1).KRC != -1) && (((f)localObject1).KRD != -1)) {
              ((AccessibilityNodeInfo)localObject2).setTextSelection(((f)localObject1).KRC, ((f)localObject1).KRD);
            }
            if ((Build.VERSION.SDK_INT > 18) && (this.KQk != null) && (this.KQk.id == paramInt)) {
              ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
            }
          }
          if (!((f)localObject1).a(b.KQO)) {
            break label1927;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(256);
        }
      }
    }
    label899:
    label1927:
    for (int j = 1;; j = 0)
    {
      if (((f)localObject1).a(b.KQP))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject1).a(b.KQY))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject1).a(b.KQZ))
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
      if ((Build.VERSION.SDK_INT >= 21) && (((f)localObject1).KRA >= 0))
      {
        if (((f)localObject1).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject2).setMaxTextLength(i - ((f)localObject1).KRB + ((f)localObject1).KRA);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (((f)localObject1).a(b.KQQ)) {
            ((AccessibilityNodeInfo)localObject2).addAction(131072);
          }
          if (((f)localObject1).a(b.KQR)) {
            ((AccessibilityNodeInfo)localObject2).addAction(16384);
          }
          if (((f)localObject1).a(b.KQS)) {
            ((AccessibilityNodeInfo)localObject2).addAction(65536);
          }
          if (((f)localObject1).a(b.KQT)) {
            ((AccessibilityNodeInfo)localObject2).addAction(32768);
          }
        }
        if ((((f)localObject1).a(d.KRf)) || (((f)localObject1).a(d.KRx))) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
        }
        if (((f)localObject1).a(d.KRq)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (((f)localObject1).a(b.KQX)))
        {
          ((AccessibilityNodeInfo)localObject2).setDismissable(true);
          ((AccessibilityNodeInfo)localObject2).addAction(1048576);
        }
        if (((f)localObject1).KRX == null) {
          break label1655;
        }
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView, ((f)localObject1).KRX.id);
        localObject3 = ((f)localObject1).KSh;
        if (((f)localObject1).KRX == null) {
          break label1667;
        }
        localObject4 = ((f)localObject1).KRX.KSh;
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
        if ((((f)localObject1).a(d.KRi)) && (!((f)localObject1).a(d.KRj))) {
          break label1677;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
        if (((f)localObject1).a(b.KQF))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).KSb == null)) {
            break label1683;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject1).KSb.hint));
          ((AccessibilityNodeInfo)localObject2).setClickable(true);
        }
        label961:
        if (((f)localObject1).a(b.KQG))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).KSc == null)) {
            break label1699;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject1).KSc.hint));
          ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        }
        if ((((f)localObject1).a(b.KQH)) || (((f)localObject1).a(b.KQJ)) || (((f)localObject1).a(b.KQI)) || (((f)localObject1).a(b.KQK)))
        {
          ((AccessibilityNodeInfo)localObject2).setScrollable(true);
          if (((f)localObject1).a(d.KRu))
          {
            if ((!((f)localObject1).a(b.KQH)) && (!((f)localObject1).a(b.KQI))) {
              break label1726;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject1))) {
              break label1715;
            }
            ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject1).KRF, false));
          }
          label1131:
          if ((((f)localObject1).a(b.KQH)) || (((f)localObject1).a(b.KQJ))) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if ((((f)localObject1).a(b.KQI)) || (((f)localObject1).a(b.KQK))) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(b.KQL)) || (((f)localObject1).a(b.KQM)))
        {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
          if (((f)localObject1).a(b.KQL)) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if (((f)localObject1).a(b.KQM)) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(d.KRr)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
        }
        boolean bool3 = ((f)localObject1).a(d.KRc);
        bool4 = ((f)localObject1).a(d.KRs);
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
          break label1783;
        }
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.KRd));
        ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
        if (!((f)localObject1).a(d.KRk)) {
          break label1772;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
        label1375:
        ((AccessibilityNodeInfo)localObject2).setSelected(((f)localObject1).a(d.KRe));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject2).setHeading(((f)localObject1).a(d.KRl));
        }
        if ((this.KQk == null) || (this.KQk.id != paramInt)) {
          break label1846;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).KSa == null)) {
          break label1856;
        }
        localObject3 = ((f)localObject1).KSa.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).resourceId, ((c)localObject4).label));
        }
        if (((((b.KQI.value | b.KQH.value | b.KQJ.value | b.KQK.value) ^ 0xFFFFFFFF) & ((f)localObject1).KRz) != 0) || (((f)localObject1).flags != 0) || ((((f)localObject1).label != null) && (!((f)localObject1).label.isEmpty())) || ((((f)localObject1).value != null) && (!((f)localObject1).value.isEmpty())) || ((((f)localObject1).hint != null) && (!((f)localObject1).hint.isEmpty())))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
        label1625:
        bool1 = false;
        break label297;
        label1631:
        bool1 = false;
        break label325;
        label1637:
        bool1 = false;
        break label397;
        i = ((f)localObject1).value.length();
        break label593;
        label1655:
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView);
        break label801;
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent((Rect)localObject3);
        break label861;
        label1677:
        bool1 = false;
        break label899;
        label1683:
        ((AccessibilityNodeInfo)localObject2).addAction(16);
        ((AccessibilityNodeInfo)localObject2).setClickable(true);
        break label961;
        label1699:
        ((AccessibilityNodeInfo)localObject2).addAction(32);
        ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        break label1016;
        label1715:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.HorizontalScrollView");
        break label1131;
        label1726:
        if ((Build.VERSION.SDK_INT > 18) && (a((f)localObject1)))
        {
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject1).KRF, 0, false));
          break label1131;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ScrollView");
        break label1131;
        label1772:
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.CheckBox");
        break label1375;
        label1783:
        if (bool4)
        {
          ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.KRt));
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
          ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
          break label1375;
        }
        if (((f)localObject1).a(d.KRn)) {
          break label1375;
        }
        ((AccessibilityNodeInfo)localObject2).setText(f.b((f)localObject1));
        break label1375;
        label1846:
        ((AccessibilityNodeInfo)localObject2).addAction(64);
      }
      label1856:
      localObject1 = ((f)localObject1).KRY.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        if (!((f)localObject3).a(d.KRp)) {
          ((AccessibilityNodeInfo)localObject2).addChild(this.rootAccessibilityView, ((f)localObject3).id);
        }
      }
      AppMethodBeat.o(9753);
      return localObject2;
    }
  }
  
  final f fNR()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.KQi.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
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
      if (this.KQo != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.KQo.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.KQm != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.KQm.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.KQk != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.KQk.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.KQl == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.KQl.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final void kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.lH.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    if (paramInt1 == 0)
    {
      this.rootAccessibilityView.sendAccessibilityEvent(paramInt2);
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(kW(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent kW(int paramInt1, int paramInt2)
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
      bool = this.KQg.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.KQl = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    f localf = (f)this.KQi.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = KQf;
      paramBundle = (c)this.KQj.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.KLm.dispatchSemanticsAction(paramInt1, b.KQW, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQF);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQG);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (localf.a(b.KQJ)) {
        this.KLm.dispatchSemanticsAction(paramInt1, b.KQJ);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.KQH))
        {
          this.KLm.dispatchSemanticsAction(paramInt1, b.KQH);
        }
        else
        {
          if (!localf.a(b.KQL)) {
            break;
          }
          localf.value = localf.KRK;
          kV(paramInt1, 4);
          this.KLm.dispatchSemanticsAction(paramInt1, b.KQL);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (localf.a(b.KQK)) {
        this.KLm.dispatchSemanticsAction(paramInt1, b.KQK);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.KQI))
        {
          this.KLm.dispatchSemanticsAction(paramInt1, b.KQI);
        }
        else
        {
          if (!localf.a(b.KQM)) {
            break;
          }
          localf.value = localf.KRL;
          kV(paramInt1, 4);
          this.KLm.dispatchSemanticsAction(paramInt1, b.KQM);
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
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQV);
      kV(paramInt1, 65536);
      this.KQk = null;
      this.KQl = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQU);
      kV(paramInt1, 32768);
      if (this.KQk == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.KQk = localf;
      if ((localf.a(b.KQL)) || (localf.a(b.KQM))) {
        kV(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQN);
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
        this.KLm.dispatchSemanticsAction(paramInt1, b.KQQ, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localf.KRD));
        localHashMap.put("extent", Integer.valueOf(localf.KRD));
      }
    case 16384: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQR);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQS);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQT);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.KLm.dispatchSemanticsAction(paramInt1, b.KQX);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    if (this.KQh != null) {
      this.KQh.fNM();
    }
    this.KLa = null;
    this.lH.removeAccessibilityStateChangeListener(this.KQv);
    if (Build.VERSION.SDK_INT >= 19) {
      this.lH.removeTouchExplorationStateChangeListener(this.KQw);
    }
    this.aDI.unregisterContentObserver(this.KQx);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.KQi.clear();
    if (this.KQk != null) {
      kV(this.KQk.id, 65536);
    }
    this.KQk = null;
    this.KQq = null;
    agF(0);
    AppMethodBeat.o(9767);
  }
  
  final void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.lH.isEnabled())
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
      KQF = new b("TAP", 0, 1);
      KQG = new b("LONG_PRESS", 1, 2);
      KQH = new b("SCROLL_LEFT", 2, 4);
      KQI = new b("SCROLL_RIGHT", 3, 8);
      KQJ = new b("SCROLL_UP", 4, 16);
      KQK = new b("SCROLL_DOWN", 5, 32);
      KQL = new b("INCREASE", 6, 64);
      KQM = new b("DECREASE", 7, 128);
      KQN = new b("SHOW_ON_SCREEN", 8, 256);
      KQO = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      KQP = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      KQQ = new b("SET_SELECTION", 11, 2048);
      KQR = new b("COPY", 12, 4096);
      KQS = new b("CUT", 13, 8192);
      KQT = new b("PASTE", 14, 16384);
      KQU = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      KQV = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      KQW = new b("CUSTOM_ACTION", 17, 131072);
      KQX = new b("DISMISS", 18, 262144);
      KQY = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      KQZ = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      KRa = new b[] { KQF, KQG, KQH, KQI, KQJ, KQK, KQL, KQM, KQN, KQO, KQP, KQQ, KQR, KQS, KQT, KQU, KQV, KQW, KQX, KQY, KQZ };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int KRb = -1;
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
      KRc = new d("HAS_CHECKED_STATE", 0, 1);
      KRd = new d("IS_CHECKED", 1, 2);
      KRe = new d("IS_SELECTED", 2, 4);
      KRf = new d("IS_BUTTON", 3, 8);
      KRg = new d("IS_TEXT_FIELD", 4, 16);
      KRh = new d("IS_FOCUSED", 5, 32);
      KRi = new d("HAS_ENABLED_STATE", 6, 64);
      KRj = new d("IS_ENABLED", 7, 128);
      KRk = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      KRl = new d("IS_HEADER", 9, 512);
      KRm = new d("IS_OBSCURED", 10, 1024);
      KRn = new d("SCOPES_ROUTE", 11, 2048);
      KRo = new d("NAMES_ROUTE", 12, 4096);
      KRp = new d("IS_HIDDEN", 13, 8192);
      KRq = new d("IS_IMAGE", 14, 16384);
      KRr = new d("IS_LIVE_REGION", 15, 32768);
      KRs = new d("HAS_TOGGLED_STATE", 16, 65536);
      KRt = new d("IS_TOGGLED", 17, 131072);
      KRu = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      KRv = new d("IS_READ_ONLY", 19, 1048576);
      KRw = new d("IS_FOCUSABLE", 20, 2097152);
      KRx = new d("IS_LINK", 21, 4194304);
      KRy = new d[] { KRc, KRd, KRe, KRf, KRg, KRh, KRi, KRj, KRk, KRl, KRm, KRn, KRo, KRp, KRq, KRr, KRs, KRt, KRu, KRv, KRw, KRx };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static abstract interface e
  {
    public abstract void aV(boolean paramBoolean1, boolean paramBoolean2);
  }
  
  static final class f
  {
    final a KKY;
    int KRA;
    int KRB;
    int KRC;
    int KRD;
    int KRE;
    int KRF;
    int KRG;
    float KRH;
    float KRI;
    float KRJ;
    String KRK;
    String KRL;
    private a.g KRM;
    boolean KRN;
    private int KRO;
    private int KRP;
    int KRQ;
    int KRR;
    float KRS;
    private float KRT;
    private float KRU;
    String KRV;
    String KRW;
    f KRX;
    List<f> KRY;
    List<f> KRZ;
    int KRz;
    List<a.c> KSa;
    a.c KSb;
    a.c KSc;
    boolean KSd;
    private float[] KSe;
    boolean KSf;
    private float[] KSg;
    Rect KSh;
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
      this.KRN = false;
      this.KRY = new ArrayList();
      this.KRZ = new ArrayList();
      this.KSd = true;
      this.KSf = true;
      this.KKY = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.KRX;
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
          paramf = paramf.KRX;
          break;
          paramf = null;
        }
      }
      label54:
      AppMethodBeat.o(9802);
      return false;
    }
    
    private static void b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
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
    
    private String fNU()
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
    
    private static float m(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.KRN = true;
      this.KRV = this.value;
      this.KRW = this.label;
      this.KRO = this.flags;
      this.KRP = this.KRz;
      this.KRQ = this.KRC;
      this.KRR = this.KRD;
      this.KRS = this.KRH;
      this.KRT = this.KRI;
      this.KRU = this.KRJ;
      this.flags = paramByteBuffer.getInt();
      this.KRz = paramByteBuffer.getInt();
      this.KRA = paramByteBuffer.getInt();
      this.KRB = paramByteBuffer.getInt();
      this.KRC = paramByteBuffer.getInt();
      this.KRD = paramByteBuffer.getInt();
      this.KRE = paramByteBuffer.getInt();
      this.KRF = paramByteBuffer.getInt();
      this.KRG = paramByteBuffer.getInt();
      this.KRH = paramByteBuffer.getFloat();
      this.KRI = paramByteBuffer.getFloat();
      this.KRJ = paramByteBuffer.getFloat();
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
        this.KRK = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.KRL = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.KRM = a.g.agG(paramByteBuffer.getInt());
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
      this.KSd = true;
      this.KSf = true;
      int j = paramByteBuffer.getInt();
      this.KRY.clear();
      this.KRZ.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.KKY, paramByteBuffer.getInt());
        paramArrayOfString.KRX = this;
        this.KRY.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.KKY, paramByteBuffer.getInt());
        paramArrayOfString.KRX = this;
        this.KRZ.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.KSa = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.KSa == null)
      {
        this.KSa = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = a.c(this.KKY, paramByteBuffer.getInt());
        if (paramArrayOfString.KRb != a.b.KQF.value) {
          break label625;
        }
        this.KSb = paramArrayOfString;
      }
      for (;;)
      {
        this.KSa.add(paramArrayOfString);
        i += 1;
        break label559;
        this.KSa.clear();
        break;
        label625:
        if (paramArrayOfString.KRb == a.b.KQG.value) {
          this.KSc = paramArrayOfString;
        } else {
          this.KSa.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.KSf) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.KSg == null) {
          this.KSg = new float[16];
        }
        Matrix.multiplyMM(this.KSg, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat1, this.KSg, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat2, this.KSg, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat3, this.KSg, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat4, this.KSg, paramArrayOfFloat);
        if (this.KSh == null) {
          this.KSh = new Rect();
        }
        this.KSh.set(Math.round(m(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(m(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(d(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(d(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.KSf = false;
      }
      paramArrayOfFloat = this.KRY.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.KSg, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.KRz & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.KRP & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.KRO & paramd.value) != 0;
    }
    
    final String fNT()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.KRo)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.KRY.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).fNT();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void iL(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.KRn)) {
        paramList.add(this);
      }
      Iterator localIterator = this.KRY.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).iL(paramList);
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
      Iterator localIterator = this.KRZ.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.KRp))
        {
          if (localf.KSd)
          {
            localf.KSd = false;
            if (localf.KSe == null) {
              localf.KSe = new float[16];
            }
            if (!Matrix.invertM(localf.KSe, 0, localf.transform, 0)) {
              Arrays.fill(localf.KSe, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.KSe, 0, paramArrayOfFloat, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     io.flutter.view.a
 * JD-Core Version:    0.7.0.1
 */