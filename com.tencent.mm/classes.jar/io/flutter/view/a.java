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
  private static int Nei = 267386881;
  public a.e MYX;
  private final io.flutter.embedding.engine.c.a MZo;
  private final ContentObserver NeA;
  public final AccessibilityViewEmbedder Nej;
  private final g Nek;
  final Map<Integer, f> Nel;
  private final Map<Integer, c> Nem;
  public f Nen;
  public Integer Neo;
  public Integer Nep;
  private int Neq;
  public f Ner;
  f Nes;
  public f Net;
  final List<Integer> Neu;
  int Nev;
  Integer New;
  private final io.flutter.embedding.engine.c.a.a Nex;
  private final AccessibilityManager.AccessibilityStateChangeListener Ney;
  @TargetApi(19)
  private final AccessibilityManager.TouchExplorationStateChangeListener Nez;
  private final ContentResolver aFz;
  public final AccessibilityManager nA;
  final View rootAccessibilityView;
  
  public a(View paramView, io.flutter.embedding.engine.c.a parama, final AccessibilityManager paramAccessibilityManager, ContentResolver paramContentResolver, g paramg)
  {
    AppMethodBeat.i(9750);
    this.Nel = new HashMap();
    this.Nem = new HashMap();
    this.Neq = 0;
    this.Neu = new ArrayList();
    this.Nev = 0;
    this.New = Integer.valueOf(0);
    this.Nex = new io.flutter.embedding.engine.c.a.a()
    {
      public final void ajH(int paramAnonymousInt)
      {
        AppMethodBeat.i(9689);
        a.a(a.this, paramAnonymousInt, 1);
        AppMethodBeat.o(9689);
      }
      
      public final void ajI(int paramAnonymousInt)
      {
        AppMethodBeat.i(9690);
        a.a(a.this, paramAnonymousInt, 2);
        AppMethodBeat.o(9690);
      }
      
      public final void bdq(String paramAnonymousString)
      {
        AppMethodBeat.i(9688);
        a.b(a.this).announceForAccessibility(paramAnonymousString);
        AppMethodBeat.o(9688);
      }
      
      public final void bdr(String paramAnonymousString)
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
          a.c localc = locala.ajP(paramAnonymousByteBuffer.getInt());
          localc.Nfd = paramAnonymousByteBuffer.getInt();
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
          localObject2 = locala.ajO(paramAnonymousByteBuffer.getInt());
          ((a.f)localObject2).a(paramAnonymousByteBuffer, paramAnonymousArrayOfString);
          if (!((a.f)localObject2).a(a.d.Nfr))
          {
            if (((a.f)localObject2).a(a.d.Nfj)) {
              locala.Ner = ((a.f)localObject2);
            }
            if (((a.f)localObject2).NfP) {
              ((ArrayList)localObject1).add(localObject2);
            }
          }
        }
        Object localObject2 = new HashSet();
        paramAnonymousByteBuffer = locala.gjS();
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
              if (!locala.New.equals(Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft())))
              {
                paramAnonymousByteBuffer.Ngh = true;
                paramAnonymousByteBuffer.Ngf = true;
              }
              locala.New = Integer.valueOf(((WindowInsets)localObject3).getSystemWindowInsetLeft());
              Matrix.translateM(paramAnonymousArrayOfString, 0, locala.New.intValue(), 0.0F, 0.0F);
            }
          }
          paramAnonymousByteBuffer.a(paramAnonymousArrayOfString, (Set)localObject2, false);
          paramAnonymousByteBuffer.ji(localArrayList);
        }
        paramAnonymousByteBuffer = null;
        Object localObject3 = localArrayList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          paramAnonymousArrayOfString = (a.f)((Iterator)localObject3).next();
          if (locala.Neu.contains(Integer.valueOf(paramAnonymousArrayOfString.id))) {
            break label1467;
          }
          paramAnonymousByteBuffer = paramAnonymousArrayOfString;
        }
        label650:
        label807:
        label1210:
        label1467:
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
          if ((paramAnonymousArrayOfString != null) && (paramAnonymousArrayOfString.id != locala.Nev))
          {
            locala.Nev = paramAnonymousArrayOfString.id;
            paramAnonymousByteBuffer = locala.ls(paramAnonymousArrayOfString.id, 32);
            paramAnonymousArrayOfString = paramAnonymousArrayOfString.gjU();
            paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
          }
          locala.Neu.clear();
          paramAnonymousByteBuffer = localArrayList.iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)paramAnonymousByteBuffer.next();
            locala.Neu.add(Integer.valueOf(paramAnonymousArrayOfString.id));
          }
          paramAnonymousByteBuffer = locala.Nel.entrySet().iterator();
          while (paramAnonymousByteBuffer.hasNext())
          {
            paramAnonymousArrayOfString = (a.f)((Map.Entry)paramAnonymousByteBuffer.next()).getValue();
            if (!((Set)localObject2).contains(paramAnonymousArrayOfString))
            {
              paramAnonymousArrayOfString.NfZ = null;
              if (locala.Nen == paramAnonymousArrayOfString)
              {
                locala.lr(locala.Nen.id, 65536);
                locala.Nen = null;
              }
              if (locala.Ner == paramAnonymousArrayOfString) {
                locala.Ner = null;
              }
              if (locala.Net == paramAnonymousArrayOfString) {
                locala.Net = null;
              }
              paramAnonymousByteBuffer.remove();
            }
          }
          locala.ajQ(0);
          localObject1 = ((ArrayList)localObject1).iterator();
          int i;
          float f3;
          float f2;
          float f1;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (a.f)((Iterator)localObject1).next();
            if ((!Float.isNaN(((a.f)localObject2).NfJ)) && (!Float.isNaN(((a.f)localObject2).NfU)) && (((a.f)localObject2).NfU != ((a.f)localObject2).NfJ))
            {
              i = 1;
              if (i == 0) {
                break label976;
              }
              paramAnonymousByteBuffer = locala.ls(((a.f)localObject2).id, 4096);
              f3 = ((a.f)localObject2).NfJ;
              f2 = ((a.f)localObject2).NfK;
              f1 = f3;
              if (Float.isInfinite(((a.f)localObject2).NfK))
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
              if (!Float.isInfinite(((a.f)localObject2).NfL)) {
                break label889;
              }
              f3 = f2 + 100000.0F;
              f2 = f1;
              if (f1 < -70000.0F) {
                f2 = -70000.0F;
              }
              f2 += 100000.0F;
              f1 = f3;
              if ((!((a.f)localObject2).b(a.b.NeL)) && (!((a.f)localObject2).b(a.b.NeM))) {
                break label918;
              }
              paramAnonymousByteBuffer.setScrollY((int)f2);
              paramAnonymousByteBuffer.setMaxScrollY((int)f1);
              if (((a.f)localObject2).NfH <= 0) {
                break label970;
              }
              paramAnonymousByteBuffer.setItemCount(((a.f)localObject2).NfH);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).NfI);
              paramAnonymousArrayOfString = ((a.f)localObject2).Ngb.iterator();
              i = 0;
              label847:
              if (!paramAnonymousArrayOfString.hasNext()) {
                break label956;
              }
              if (((a.f)paramAnonymousArrayOfString.next()).a(a.d.Nfr)) {
                break label1464;
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
            f2 -= ((a.f)localObject2).NfL;
            f3 = f1 - ((a.f)localObject2).NfL;
            f1 = f2;
            f2 = f3;
            break label772;
            if ((!((a.f)localObject2).b(a.b.NeJ)) && (!((a.f)localObject2).b(a.b.NeK))) {
              break label807;
            }
            paramAnonymousByteBuffer.setScrollX((int)f2);
            paramAnonymousByteBuffer.setMaxScrollX((int)f1);
            break label807;
            label956:
            paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).NfI + i - 1);
            label970:
            locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            label976:
            if (((a.f)localObject2).a(a.d.Nft))
            {
              if (((((a.f)localObject2).label == null) && (((a.f)localObject2).NfY == null)) || ((((a.f)localObject2).label != null) && (((a.f)localObject2).NfY != null) && (((a.f)localObject2).label.equals(((a.f)localObject2).NfY)))) {
                break label1420;
              }
              i = 1;
              if (i != 0) {
                locala.ajQ(((a.f)localObject2).id);
              }
            }
            if ((locala.Nen != null) && (locala.Nen.id == ((a.f)localObject2).id) && (!((a.f)localObject2).b(a.d.Nfg)) && (((a.f)localObject2).a(a.d.Nfg)))
            {
              paramAnonymousByteBuffer = locala.ls(((a.f)localObject2).id, 4);
              paramAnonymousByteBuffer.getText().add(((a.f)localObject2).label);
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
            }
            if ((locala.Ner != null) && (locala.Ner.id == ((a.f)localObject2).id) && ((locala.Nes == null) || (locala.Nes.id != locala.Ner.id)))
            {
              locala.Nes = locala.Ner;
              locala.sendAccessibilityEvent(locala.ls(((a.f)localObject2).id, 8));
              if ((locala.Ner == null) || (locala.Ner.id != ((a.f)localObject2).id) || (!((a.f)localObject2).b(a.d.Nfi)) || (!((a.f)localObject2).a(a.d.Nfi)) || ((locala.Nen != null) && (locala.Nen.id != locala.Ner.id))) {
                break label1441;
              }
              if (((a.f)localObject2).NfX == null) {
                break label1443;
              }
              paramAnonymousByteBuffer = ((a.f)localObject2).NfX;
              if (((a.f)localObject2).value == null) {
                break label1450;
              }
            }
            for (paramAnonymousArrayOfString = ((a.f)localObject2).value;; paramAnonymousArrayOfString = "")
            {
              paramAnonymousByteBuffer = locala.ab(((a.f)localObject2).id, paramAnonymousByteBuffer, paramAnonymousArrayOfString);
              if (paramAnonymousByteBuffer != null) {
                locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              }
              if ((((a.f)localObject2).NfS == ((a.f)localObject2).NfE) && (((a.f)localObject2).NfT == ((a.f)localObject2).NfF)) {
                break;
              }
              paramAnonymousByteBuffer = locala.ls(((a.f)localObject2).id, 8192);
              paramAnonymousByteBuffer.getText().add(paramAnonymousArrayOfString);
              paramAnonymousByteBuffer.setFromIndex(((a.f)localObject2).NfE);
              paramAnonymousByteBuffer.setToIndex(((a.f)localObject2).NfF);
              paramAnonymousByteBuffer.setItemCount(paramAnonymousArrayOfString.length());
              locala.sendAccessibilityEvent(paramAnonymousByteBuffer);
              break;
              i = 0;
              break label1038;
              if (locala.Ner != null) {
                break label1210;
              }
              locala.Nes = null;
              break label1210;
              break;
              paramAnonymousByteBuffer = "";
              break label1297;
            }
            AppMethodBeat.o(9693);
            return;
          }
        }
      }
    };
    this.Ney = new a.2(this);
    this.NeA = new ContentObserver(new Handler())
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
          a.a(a.this, a.i(a.this) | a.a.NeF.value);
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
          a.a(a.this, a.i(a.this) & (a.a.NeF.value ^ 0xFFFFFFFF));
        }
      }
    };
    this.rootAccessibilityView = paramView;
    this.MZo = parama;
    this.nA = paramAccessibilityManager;
    this.aFz = paramContentResolver;
    this.Nek = paramg;
    this.Ney.onAccessibilityStateChanged(paramAccessibilityManager.isEnabled());
    this.nA.addAccessibilityStateChangeListener(this.Ney);
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.Nez = new AccessibilityManager.TouchExplorationStateChangeListener()
      {
        public final void onTouchExplorationStateChanged(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(9778);
          if (paramAnonymousBoolean) {
            a.a(a.this, a.i(a.this) | a.a.NeD.value);
          }
          for (;;)
          {
            a.j(a.this);
            if (a.f(a.this) != null) {
              a.f(a.this).bc(paramAccessibilityManager.isEnabled(), paramAnonymousBoolean);
            }
            AppMethodBeat.o(9778);
            return;
            a.k(a.this);
            a.a(a.this, a.i(a.this) & (a.a.NeD.value ^ 0xFFFFFFFF));
          }
        }
      };
      this.Nez.onTouchExplorationStateChanged(paramAccessibilityManager.isTouchExplorationEnabled());
      this.nA.addTouchExplorationStateChangeListener(this.Nez);
    }
    for (;;)
    {
      if (Build.VERSION.SDK_INT >= 17)
      {
        this.NeA.onChange(false);
        parama = Settings.Global.getUriFor("transition_animation_scale");
        this.aFz.registerContentObserver(parama, false, this.NeA);
      }
      if (paramg != null) {
        paramg.a(this);
      }
      this.Nej = new AccessibilityViewEmbedder(paramView, 65536);
      AppMethodBeat.o(9750);
      return;
      this.Nez = null;
    }
  }
  
  private boolean a(final f paramf)
  {
    AppMethodBeat.i(9752);
    if ((paramf.NfH > 0) && ((f.a(this.Nen, new c() {})) || (!f.a(this.Nen, new c() {}))))
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
        if ((paramBoolean) && (paramf.a(b.NeQ)))
        {
          this.MZo.dispatchSemanticsAction(paramInt, b.NeQ, Boolean.valueOf(bool));
          AppMethodBeat.o(9755);
          return true;
        }
      } while ((paramBoolean) || (!paramf.a(b.NeR)));
      this.MZo.dispatchSemanticsAction(paramInt, b.NeR, Boolean.valueOf(bool));
      AppMethodBeat.o(9755);
      return true;
      if ((paramBoolean) && (paramf.a(b.Nfa)))
      {
        this.MZo.dispatchSemanticsAction(paramInt, b.Nfa, Boolean.valueOf(bool));
        AppMethodBeat.o(9755);
        return true;
      }
    } while ((paramBoolean) || (!paramf.a(b.Nfb)));
    this.MZo.dispatchSemanticsAction(paramInt, b.Nfb, Boolean.valueOf(bool));
    AppMethodBeat.o(9755);
    return true;
  }
  
  private void au(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(9762);
    if (this.Nel.isEmpty())
    {
      AppMethodBeat.o(9762);
      return;
    }
    f localf = gjS().r(new float[] { paramFloat1, paramFloat2, 0.0F, 1.0F });
    if (localf != this.Net)
    {
      if (localf != null) {
        lr(localf.id, 128);
      }
      if (this.Net != null) {
        lr(this.Net.id, 256);
      }
      this.Net = localf;
    }
    AppMethodBeat.o(9762);
  }
  
  private void gjT()
  {
    AppMethodBeat.i(9761);
    if (this.Net != null)
    {
      lr(this.Net.id, 256);
      this.Net = null;
    }
    AppMethodBeat.o(9761);
  }
  
  final AccessibilityEvent ab(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(9763);
    AccessibilityEvent localAccessibilityEvent = ls(paramInt, 16);
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
  
  final f ajO(int paramInt)
  {
    AppMethodBeat.i(9758);
    f localf2 = (f)this.Nel.get(Integer.valueOf(paramInt));
    f localf1 = localf2;
    if (localf2 == null)
    {
      localf1 = new f(this);
      localf1.id = paramInt;
      this.Nel.put(Integer.valueOf(paramInt), localf1);
    }
    AppMethodBeat.o(9758);
    return localf1;
  }
  
  final c ajP(int paramInt)
  {
    AppMethodBeat.i(9759);
    c localc2 = (c)this.Nem.get(Integer.valueOf(paramInt));
    c localc1 = localc2;
    if (localc2 == null)
    {
      localc1 = new c();
      localc1.id = paramInt;
      localc1.resourceId = (Nei + paramInt);
      this.Nem.put(Integer.valueOf(paramInt), localc1);
    }
    AppMethodBeat.o(9759);
    return localc1;
  }
  
  final void ajQ(int paramInt)
  {
    AppMethodBeat.i(197821);
    AccessibilityEvent localAccessibilityEvent = ls(paramInt, 2048);
    if (Build.VERSION.SDK_INT >= 19) {
      localAccessibilityEvent.setContentChangeTypes(1);
    }
    sendAccessibilityEvent(localAccessibilityEvent);
    AppMethodBeat.o(197821);
  }
  
  public final boolean an(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(9760);
    if (!this.nA.isTouchExplorationEnabled())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    if (this.Nel.isEmpty())
    {
      AppMethodBeat.o(9760);
      return false;
    }
    f localf = gjS().r(new float[] { paramMotionEvent.getX(), paramMotionEvent.getY(), 0.0F, 1.0F });
    if (localf.NfG != -1)
    {
      boolean bool = this.Nej.onAccessibilityHoverEvent(localf.id, paramMotionEvent);
      AppMethodBeat.o(9760);
      return bool;
    }
    if ((paramMotionEvent.getAction() == 9) || (paramMotionEvent.getAction() == 7)) {
      au(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
    for (;;)
    {
      AppMethodBeat.o(9760);
      return true;
      if (paramMotionEvent.getAction() != 10) {
        break;
      }
      gjT();
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
      localObject1 = this.Nej.createAccessibilityNodeInfo(paramInt);
      AppMethodBeat.o(9753);
      return localObject1;
    }
    if (paramInt == -1)
    {
      localObject1 = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
      this.rootAccessibilityView.onInitializeAccessibilityNodeInfo((AccessibilityNodeInfo)localObject1);
      if (this.Nel.containsKey(Integer.valueOf(0))) {
        ((AccessibilityNodeInfo)localObject1).addChild(this.rootAccessibilityView, 0);
      }
      AppMethodBeat.o(9753);
      return localObject1;
    }
    Object localObject1 = (f)this.Nel.get(Integer.valueOf(paramInt));
    if (localObject1 == null)
    {
      AppMethodBeat.o(9753);
      return null;
    }
    Object localObject3;
    if (((f)localObject1).NfG != -1)
    {
      localObject2 = this.Nek.q(Integer.valueOf(((f)localObject1).NfG));
      localObject3 = ((f)localObject1).Ngj;
      localObject1 = this.Nej.getRootNode((View)localObject2, ((f)localObject1).id, (Rect)localObject3);
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
    if (!((f)localObject1).a(d.Nfp)) {
      if (((f)localObject1).a(d.Nfy))
      {
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setFocusable(bool1);
        if (this.Ner != null)
        {
          if (this.Ner.id != paramInt) {
            break label1625;
          }
          bool1 = true;
          label297:
          ((AccessibilityNodeInfo)localObject2).setFocused(bool1);
        }
        if (this.Nen != null)
        {
          if (this.Nen.id != paramInt) {
            break label1631;
          }
          bool1 = true;
          label325:
          ((AccessibilityNodeInfo)localObject2).setAccessibilityFocused(bool1);
        }
        if (((f)localObject1).a(d.Nfi))
        {
          ((AccessibilityNodeInfo)localObject2).setPassword(((f)localObject1).a(d.Nfo));
          if (!((f)localObject1).a(d.Nfx)) {
            ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.EditText");
          }
          if (Build.VERSION.SDK_INT >= 18)
          {
            if (((f)localObject1).a(d.Nfx)) {
              break label1637;
            }
            bool1 = true;
            label397:
            ((AccessibilityNodeInfo)localObject2).setEditable(bool1);
            if ((((f)localObject1).NfE != -1) && (((f)localObject1).NfF != -1)) {
              ((AccessibilityNodeInfo)localObject2).setTextSelection(((f)localObject1).NfE, ((f)localObject1).NfF);
            }
            if ((Build.VERSION.SDK_INT > 18) && (this.Nen != null) && (this.Nen.id == paramInt)) {
              ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
            }
          }
          if (!((f)localObject1).a(b.NeQ)) {
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
      if (((f)localObject1).a(b.NeR))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(512);
        j = 1;
      }
      int i = j;
      if (((f)localObject1).a(b.Nfa))
      {
        ((AccessibilityNodeInfo)localObject2).addAction(256);
        i = j | 0x2;
      }
      j = i;
      if (((f)localObject1).a(b.Nfb))
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
      if ((Build.VERSION.SDK_INT >= 21) && (((f)localObject1).NfC >= 0))
      {
        if (((f)localObject1).value == null)
        {
          i = 0;
          ((AccessibilityNodeInfo)localObject2).setMaxTextLength(i - ((f)localObject1).NfD + ((f)localObject1).NfC);
        }
      }
      else
      {
        if (Build.VERSION.SDK_INT > 18)
        {
          if (((f)localObject1).a(b.NeS)) {
            ((AccessibilityNodeInfo)localObject2).addAction(131072);
          }
          if (((f)localObject1).a(b.NeT)) {
            ((AccessibilityNodeInfo)localObject2).addAction(16384);
          }
          if (((f)localObject1).a(b.NeU)) {
            ((AccessibilityNodeInfo)localObject2).addAction(65536);
          }
          if (((f)localObject1).a(b.NeV)) {
            ((AccessibilityNodeInfo)localObject2).addAction(32768);
          }
        }
        if ((((f)localObject1).a(d.Nfh)) || (((f)localObject1).a(d.Nfz))) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Button");
        }
        if (((f)localObject1).a(d.Nfs)) {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.ImageView");
        }
        if ((Build.VERSION.SDK_INT > 18) && (((f)localObject1).a(b.NeZ)))
        {
          ((AccessibilityNodeInfo)localObject2).setDismissable(true);
          ((AccessibilityNodeInfo)localObject2).addAction(1048576);
        }
        if (((f)localObject1).NfZ == null) {
          break label1655;
        }
        ((AccessibilityNodeInfo)localObject2).setParent(this.rootAccessibilityView, ((f)localObject1).NfZ.id);
        localObject3 = ((f)localObject1).Ngj;
        if (((f)localObject1).NfZ == null) {
          break label1667;
        }
        localObject4 = ((f)localObject1).NfZ.Ngj;
        Rect localRect = new Rect((Rect)localObject3);
        localRect.offset(-((Rect)localObject4).left, -((Rect)localObject4).top);
        ((AccessibilityNodeInfo)localObject2).setBoundsInParent(localRect);
        ((AccessibilityNodeInfo)localObject2).setBoundsInScreen((Rect)localObject3);
        ((AccessibilityNodeInfo)localObject2).setVisibleToUser(true);
        if ((((f)localObject1).a(d.Nfk)) && (!((f)localObject1).a(d.Nfl))) {
          break label1677;
        }
        bool1 = true;
        ((AccessibilityNodeInfo)localObject2).setEnabled(bool1);
        if (((f)localObject1).a(b.NeH))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).Ngd == null)) {
            break label1683;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(16, ((f)localObject1).Ngd.hint));
          ((AccessibilityNodeInfo)localObject2).setClickable(true);
        }
        label961:
        if (((f)localObject1).a(b.NeI))
        {
          if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).Nge == null)) {
            break label1699;
          }
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(32, ((f)localObject1).Nge.hint));
          ((AccessibilityNodeInfo)localObject2).setLongClickable(true);
        }
        if ((((f)localObject1).a(b.NeJ)) || (((f)localObject1).a(b.NeL)) || (((f)localObject1).a(b.NeK)) || (((f)localObject1).a(b.NeM)))
        {
          ((AccessibilityNodeInfo)localObject2).setScrollable(true);
          if (((f)localObject1).a(d.Nfw))
          {
            if ((!((f)localObject1).a(b.NeJ)) && (!((f)localObject1).a(b.NeK))) {
              break label1726;
            }
            if ((Build.VERSION.SDK_INT <= 19) || (!a((f)localObject1))) {
              break label1715;
            }
            ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, ((f)localObject1).NfH, false));
          }
          label1131:
          if ((((f)localObject1).a(b.NeJ)) || (((f)localObject1).a(b.NeL))) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if ((((f)localObject1).a(b.NeK)) || (((f)localObject1).a(b.NeM))) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(b.NeN)) || (((f)localObject1).a(b.NeO)))
        {
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.SeekBar");
          if (((f)localObject1).a(b.NeN)) {
            ((AccessibilityNodeInfo)localObject2).addAction(4096);
          }
          if (((f)localObject1).a(b.NeO)) {
            ((AccessibilityNodeInfo)localObject2).addAction(8192);
          }
        }
        if ((((f)localObject1).a(d.Nft)) && (Build.VERSION.SDK_INT > 18)) {
          ((AccessibilityNodeInfo)localObject2).setLiveRegion(1);
        }
        boolean bool3 = ((f)localObject1).a(d.Nfe);
        bool4 = ((f)localObject1).a(d.Nfu);
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
        ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.Nff));
        ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
        if (!((f)localObject1).a(d.Nfm)) {
          break label1772;
        }
        ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.RadioButton");
        label1375:
        ((AccessibilityNodeInfo)localObject2).setSelected(((f)localObject1).a(d.Nfg));
        if (Build.VERSION.SDK_INT >= 28) {
          ((AccessibilityNodeInfo)localObject2).setHeading(((f)localObject1).a(d.Nfn));
        }
        if ((this.Nen == null) || (this.Nen.id != paramInt)) {
          break label1846;
        }
        ((AccessibilityNodeInfo)localObject2).addAction(128);
      }
      for (;;)
      {
        if ((Build.VERSION.SDK_INT < 21) || (((f)localObject1).Ngc == null)) {
          break label1856;
        }
        localObject3 = ((f)localObject1).Ngc.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (c)((Iterator)localObject3).next();
          ((AccessibilityNodeInfo)localObject2).addAction(new AccessibilityNodeInfo.AccessibilityAction(((c)localObject4).resourceId, ((c)localObject4).label));
        }
        if (((((b.NeK.value | b.NeJ.value | b.NeL.value | b.NeM.value) ^ 0xFFFFFFFF) & ((f)localObject1).NfB) != 0) || (((f)localObject1).flags != 0) || ((((f)localObject1).label != null) && (!((f)localObject1).label.isEmpty())) || ((((f)localObject1).value != null) && (!((f)localObject1).value.isEmpty())) || ((((f)localObject1).hint != null) && (!((f)localObject1).hint.isEmpty())))
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
          ((AccessibilityNodeInfo)localObject2).setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(((f)localObject1).NfH, 0, false));
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
          ((AccessibilityNodeInfo)localObject2).setChecked(((f)localObject1).a(d.Nfv));
          ((AccessibilityNodeInfo)localObject2).setClassName("android.widget.Switch");
          ((AccessibilityNodeInfo)localObject2).setContentDescription(f.b((f)localObject1));
          break label1375;
        }
        if (((f)localObject1).a(d.Nfp)) {
          break label1375;
        }
        ((AccessibilityNodeInfo)localObject2).setText(f.b((f)localObject1));
        break label1375;
        label1846:
        ((AccessibilityNodeInfo)localObject2).addAction(64);
      }
      label1856:
      localObject1 = ((f)localObject1).Nga.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        if (!((f)localObject3).a(d.Nfr)) {
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
      if (this.Ner != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.Ner.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.Nep != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.Nep.intValue());
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
      if (this.Nen != null)
      {
        localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.Nen.id);
        AppMethodBeat.o(9756);
        return localAccessibilityNodeInfo;
      }
    } while (this.Neo == null);
    AccessibilityNodeInfo localAccessibilityNodeInfo = createAccessibilityNodeInfo(this.Neo.intValue());
    AppMethodBeat.o(9756);
    return localAccessibilityNodeInfo;
  }
  
  final f gjS()
  {
    AppMethodBeat.i(9757);
    f localf = (f)this.Nel.get(Integer.valueOf(0));
    AppMethodBeat.o(9757);
    return localf;
  }
  
  final void lr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9764);
    if (!this.nA.isEnabled())
    {
      AppMethodBeat.o(9764);
      return;
    }
    sendAccessibilityEvent(ls(paramInt1, paramInt2));
    AppMethodBeat.o(9764);
  }
  
  final AccessibilityEvent ls(int paramInt1, int paramInt2)
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
      bool = this.Nej.performAction(paramInt1, paramInt2, paramBundle);
      if ((bool) && (paramInt2 == 128)) {
        this.Neo = null;
      }
      AppMethodBeat.o(9754);
      return bool;
    }
    f localf = (f)this.Nel.get(Integer.valueOf(paramInt1));
    if (localf == null)
    {
      AppMethodBeat.o(9754);
      return false;
    }
    switch (paramInt2)
    {
    default: 
      i = Nei;
      paramBundle = (c)this.Nem.get(Integer.valueOf(paramInt2 - i));
      if (paramBundle != null)
      {
        this.MZo.dispatchSemanticsAction(paramInt1, b.NeY, Integer.valueOf(paramBundle.id));
        AppMethodBeat.o(9754);
        return true;
      }
      break;
    case 16: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeH);
      AppMethodBeat.o(9754);
      return true;
    case 32: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeI);
      AppMethodBeat.o(9754);
      return true;
    case 4096: 
      if (localf.a(b.NeL)) {
        this.MZo.dispatchSemanticsAction(paramInt1, b.NeL);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.NeJ))
        {
          this.MZo.dispatchSemanticsAction(paramInt1, b.NeJ);
        }
        else
        {
          if (!localf.a(b.NeN)) {
            break;
          }
          localf.value = localf.NfM;
          lr(paramInt1, 4);
          this.MZo.dispatchSemanticsAction(paramInt1, b.NeN);
        }
      }
      AppMethodBeat.o(9754);
      return false;
    case 8192: 
      if (localf.a(b.NeM)) {
        this.MZo.dispatchSemanticsAction(paramInt1, b.NeM);
      }
      for (;;)
      {
        AppMethodBeat.o(9754);
        return true;
        if (localf.a(b.NeK))
        {
          this.MZo.dispatchSemanticsAction(paramInt1, b.NeK);
        }
        else
        {
          if (!localf.a(b.NeO)) {
            break;
          }
          localf.value = localf.NfN;
          lr(paramInt1, 4);
          this.MZo.dispatchSemanticsAction(paramInt1, b.NeO);
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
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeX);
      lr(paramInt1, 65536);
      this.Nen = null;
      this.Neo = null;
      AppMethodBeat.o(9754);
      return true;
    case 64: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeW);
      lr(paramInt1, 32768);
      if (this.Nen == null) {
        this.rootAccessibilityView.invalidate();
      }
      this.Nen = localf;
      if ((localf.a(b.NeN)) || (localf.a(b.NeO))) {
        lr(paramInt1, 4);
      }
      AppMethodBeat.o(9754);
      return true;
    case 16908342: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeP);
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
        this.MZo.dispatchSemanticsAction(paramInt1, b.NeS, localHashMap);
        AppMethodBeat.o(9754);
        return true;
        localHashMap.put("base", Integer.valueOf(localf.NfF));
        localHashMap.put("extent", Integer.valueOf(localf.NfF));
      }
    case 16384: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeT);
      AppMethodBeat.o(9754);
      return true;
    case 65536: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeU);
      AppMethodBeat.o(9754);
      return true;
    case 32768: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeV);
      AppMethodBeat.o(9754);
      return true;
    case 1048576: 
      this.MZo.dispatchSemanticsAction(paramInt1, b.NeZ);
      AppMethodBeat.o(9754);
      return true;
    }
    AppMethodBeat.o(9754);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(9751);
    if (this.Nek != null) {
      this.Nek.gjN();
    }
    this.MYX = null;
    this.nA.removeAccessibilityStateChangeListener(this.Ney);
    if (Build.VERSION.SDK_INT >= 19) {
      this.nA.removeTouchExplorationStateChangeListener(this.Nez);
    }
    this.aFz.unregisterContentObserver(this.NeA);
    AppMethodBeat.o(9751);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(9767);
    this.Nel.clear();
    if (this.Nen != null) {
      lr(this.Nen.id, 65536);
    }
    this.Nen = null;
    this.Net = null;
    ajQ(0);
    AppMethodBeat.o(9767);
  }
  
  final void sendAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(9765);
    if (!this.nA.isEnabled())
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
      NeH = new b("TAP", 0, 1);
      NeI = new b("LONG_PRESS", 1, 2);
      NeJ = new b("SCROLL_LEFT", 2, 4);
      NeK = new b("SCROLL_RIGHT", 3, 8);
      NeL = new b("SCROLL_UP", 4, 16);
      NeM = new b("SCROLL_DOWN", 5, 32);
      NeN = new b("INCREASE", 6, 64);
      NeO = new b("DECREASE", 7, 128);
      NeP = new b("SHOW_ON_SCREEN", 8, 256);
      NeQ = new b("MOVE_CURSOR_FORWARD_BY_CHARACTER", 9, 512);
      NeR = new b("MOVE_CURSOR_BACKWARD_BY_CHARACTER", 10, 1024);
      NeS = new b("SET_SELECTION", 11, 2048);
      NeT = new b("COPY", 12, 4096);
      NeU = new b("CUT", 13, 8192);
      NeV = new b("PASTE", 14, 16384);
      NeW = new b("DID_GAIN_ACCESSIBILITY_FOCUS", 15, 32768);
      NeX = new b("DID_LOSE_ACCESSIBILITY_FOCUS", 16, 65536);
      NeY = new b("CUSTOM_ACTION", 17, 131072);
      NeZ = new b("DISMISS", 18, 262144);
      Nfa = new b("MOVE_CURSOR_FORWARD_BY_WORD", 19, 524288);
      Nfb = new b("MOVE_CURSOR_BACKWARD_BY_WORD", 20, 1048576);
      Nfc = new b[] { NeH, NeI, NeJ, NeK, NeL, NeM, NeN, NeO, NeP, NeQ, NeR, NeS, NeT, NeU, NeV, NeW, NeX, NeY, NeZ, Nfa, Nfb };
      AppMethodBeat.o(9783);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class c
  {
    int Nfd = -1;
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
      Nfe = new d("HAS_CHECKED_STATE", 0, 1);
      Nff = new d("IS_CHECKED", 1, 2);
      Nfg = new d("IS_SELECTED", 2, 4);
      Nfh = new d("IS_BUTTON", 3, 8);
      Nfi = new d("IS_TEXT_FIELD", 4, 16);
      Nfj = new d("IS_FOCUSED", 5, 32);
      Nfk = new d("HAS_ENABLED_STATE", 6, 64);
      Nfl = new d("IS_ENABLED", 7, 128);
      Nfm = new d("IS_IN_MUTUALLY_EXCLUSIVE_GROUP", 8, 256);
      Nfn = new d("IS_HEADER", 9, 512);
      Nfo = new d("IS_OBSCURED", 10, 1024);
      Nfp = new d("SCOPES_ROUTE", 11, 2048);
      Nfq = new d("NAMES_ROUTE", 12, 4096);
      Nfr = new d("IS_HIDDEN", 13, 8192);
      Nfs = new d("IS_IMAGE", 14, 16384);
      Nft = new d("IS_LIVE_REGION", 15, 32768);
      Nfu = new d("HAS_TOGGLED_STATE", 16, 65536);
      Nfv = new d("IS_TOGGLED", 17, 131072);
      Nfw = new d("HAS_IMPLICIT_SCROLLING", 18, 262144);
      Nfx = new d("IS_READ_ONLY", 19, 1048576);
      Nfy = new d("IS_FOCUSABLE", 20, 2097152);
      Nfz = new d("IS_LINK", 21, 4194304);
      NfA = new d[] { Nfe, Nff, Nfg, Nfh, Nfi, Nfj, Nfk, Nfl, Nfm, Nfn, Nfo, Nfp, Nfq, Nfr, Nfs, Nft, Nfu, Nfv, Nfw, Nfx, Nfy, Nfz };
      AppMethodBeat.o(9679);
    }
    
    private d(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  static final class f
  {
    final a MYV;
    int NfB;
    int NfC;
    int NfD;
    int NfE;
    int NfF;
    int NfG;
    int NfH;
    int NfI;
    float NfJ;
    float NfK;
    float NfL;
    String NfM;
    String NfN;
    private a.g NfO;
    boolean NfP;
    private int NfQ;
    private int NfR;
    int NfS;
    int NfT;
    float NfU;
    private float NfV;
    private float NfW;
    String NfX;
    String NfY;
    f NfZ;
    List<f> Nga;
    List<f> Ngb;
    List<a.c> Ngc;
    a.c Ngd;
    a.c Nge;
    boolean Ngf;
    private float[] Ngg;
    boolean Ngh;
    private float[] Ngi;
    Rect Ngj;
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
      this.NfP = false;
      this.Nga = new ArrayList();
      this.Ngb = new ArrayList();
      this.Ngf = true;
      this.Ngh = true;
      this.MYV = parama;
      AppMethodBeat.o(9803);
    }
    
    static boolean a(f paramf, c<f> paramc)
    {
      AppMethodBeat.i(9802);
      if (paramf != null)
      {
        paramf = paramf.NfZ;
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
          paramf = paramf.NfZ;
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
    
    private String gjV()
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
    
    private static float q(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(9810);
      paramFloat1 = Math.min(paramFloat1, Math.min(paramFloat2, Math.min(paramFloat3, paramFloat4)));
      AppMethodBeat.o(9810);
      return paramFloat1;
    }
    
    final void a(ByteBuffer paramByteBuffer, String[] paramArrayOfString)
    {
      AppMethodBeat.i(9804);
      this.NfP = true;
      this.NfX = this.value;
      this.NfY = this.label;
      this.NfQ = this.flags;
      this.NfR = this.NfB;
      this.NfS = this.NfE;
      this.NfT = this.NfF;
      this.NfU = this.NfJ;
      this.NfV = this.NfK;
      this.NfW = this.NfL;
      this.flags = paramByteBuffer.getInt();
      this.NfB = paramByteBuffer.getInt();
      this.NfC = paramByteBuffer.getInt();
      this.NfD = paramByteBuffer.getInt();
      this.NfE = paramByteBuffer.getInt();
      this.NfF = paramByteBuffer.getInt();
      this.NfG = paramByteBuffer.getInt();
      this.NfH = paramByteBuffer.getInt();
      this.NfI = paramByteBuffer.getInt();
      this.NfJ = paramByteBuffer.getFloat();
      this.NfK = paramByteBuffer.getFloat();
      this.NfL = paramByteBuffer.getFloat();
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
        this.NfM = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label379;
        }
        str = null;
        label249:
        this.NfN = str;
        i = paramByteBuffer.getInt();
        if (i != -1) {
          break label387;
        }
      }
      label387:
      for (paramArrayOfString = null;; paramArrayOfString = paramArrayOfString[i])
      {
        this.hint = paramArrayOfString;
        this.NfO = a.g.ajR(paramByteBuffer.getInt());
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
      this.Ngf = true;
      this.Ngh = true;
      int j = paramByteBuffer.getInt();
      this.Nga.clear();
      this.Ngb.clear();
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.MYV, paramByteBuffer.getInt());
        paramArrayOfString.NfZ = this;
        this.Nga.add(paramArrayOfString);
        i += 1;
      }
      i = 0;
      while (i < j)
      {
        paramArrayOfString = a.b(this.MYV, paramByteBuffer.getInt());
        paramArrayOfString.NfZ = this;
        this.Ngb.add(paramArrayOfString);
        i += 1;
      }
      j = paramByteBuffer.getInt();
      if (j == 0)
      {
        this.Ngc = null;
        AppMethodBeat.o(9804);
        return;
      }
      if (this.Ngc == null)
      {
        this.Ngc = new ArrayList(j);
        i = 0;
        label559:
        if (i >= j) {
          break label660;
        }
        paramArrayOfString = a.c(this.MYV, paramByteBuffer.getInt());
        if (paramArrayOfString.Nfd != a.b.NeH.value) {
          break label625;
        }
        this.Ngd = paramArrayOfString;
      }
      for (;;)
      {
        this.Ngc.add(paramArrayOfString);
        i += 1;
        break label559;
        this.Ngc.clear();
        break;
        label625:
        if (paramArrayOfString.Nfd == a.b.NeI.value) {
          this.Nge = paramArrayOfString;
        } else {
          this.Ngc.add(paramArrayOfString);
        }
      }
      label660:
      AppMethodBeat.o(9804);
    }
    
    final void a(float[] paramArrayOfFloat, Set<f> paramSet, boolean paramBoolean)
    {
      AppMethodBeat.i(9808);
      paramSet.add(this);
      if (this.Ngh) {
        paramBoolean = true;
      }
      if (paramBoolean)
      {
        if (this.Ngi == null) {
          this.Ngi = new float[16];
        }
        Matrix.multiplyMM(this.Ngi, 0, paramArrayOfFloat, 0, this.transform, 0);
        paramArrayOfFloat = new float[4];
        paramArrayOfFloat[2] = 0.0F;
        paramArrayOfFloat[3] = 1.0F;
        float[] arrayOfFloat1 = new float[4];
        float[] arrayOfFloat2 = new float[4];
        float[] arrayOfFloat3 = new float[4];
        float[] arrayOfFloat4 = new float[4];
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat1, this.Ngi, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.top;
        b(arrayOfFloat2, this.Ngi, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.right;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat3, this.Ngi, paramArrayOfFloat);
        paramArrayOfFloat[0] = this.left;
        paramArrayOfFloat[1] = this.bottom;
        b(arrayOfFloat4, this.Ngi, paramArrayOfFloat);
        if (this.Ngj == null) {
          this.Ngj = new Rect();
        }
        this.Ngj.set(Math.round(q(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(q(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])), Math.round(d(arrayOfFloat1[0], arrayOfFloat2[0], arrayOfFloat3[0], arrayOfFloat4[0])), Math.round(d(arrayOfFloat1[1], arrayOfFloat2[1], arrayOfFloat3[1], arrayOfFloat4[1])));
        this.Ngh = false;
      }
      paramArrayOfFloat = this.Nga.iterator();
      while (paramArrayOfFloat.hasNext()) {
        ((f)paramArrayOfFloat.next()).a(this.Ngi, paramSet, paramBoolean);
      }
      AppMethodBeat.o(9808);
    }
    
    final boolean a(a.b paramb)
    {
      return (this.NfB & paramb.value) != 0;
    }
    
    final boolean a(a.d paramd)
    {
      return (this.flags & paramd.value) != 0;
    }
    
    final boolean b(a.b paramb)
    {
      return (this.NfR & paramb.value) != 0;
    }
    
    final boolean b(a.d paramd)
    {
      return (this.NfQ & paramd.value) != 0;
    }
    
    final String gjU()
    {
      AppMethodBeat.i(9807);
      if ((a(a.d.Nfq)) && (this.label != null) && (!this.label.isEmpty()))
      {
        localObject = this.label;
        AppMethodBeat.o(9807);
        return localObject;
      }
      Object localObject = this.Nga.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((f)((Iterator)localObject).next()).gjU();
        if ((str != null) && (!str.isEmpty()))
        {
          AppMethodBeat.o(9807);
          return str;
        }
      }
      AppMethodBeat.o(9807);
      return null;
    }
    
    final void ji(List<f> paramList)
    {
      AppMethodBeat.i(9806);
      if (a(a.d.Nfp)) {
        paramList.add(this);
      }
      Iterator localIterator = this.Nga.iterator();
      while (localIterator.hasNext()) {
        ((f)localIterator.next()).ji(paramList);
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
      Iterator localIterator = this.Ngb.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.a(a.d.Nfr))
        {
          if (localf.Ngf)
          {
            localf.Ngf = false;
            if (localf.Ngg == null) {
              localf.Ngg = new float[16];
            }
            if (!Matrix.invertM(localf.Ngg, 0, localf.transform, 0)) {
              Arrays.fill(localf.Ngg, 0.0F);
            }
          }
          Matrix.multiplyMV(arrayOfFloat, 0, localf.Ngg, 0, paramArrayOfFloat, 0);
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