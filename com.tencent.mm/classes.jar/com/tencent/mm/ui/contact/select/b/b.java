package com.tencent.mm.ui.contact.select.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.statecenter.IStateAction;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.contact.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC;", "Lcom/tencent/mm/ui/mvvm/uic/BaseSelectContactLiveListUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "initHeaderView", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBizEntranceClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onFaceChatClick", "onGroupCardClick", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;", "onOpenImCardClick", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.ui.mvvm.b.a
{
  public static final b.a aflB;
  
  static
  {
    AppMethodBeat.i(253175);
    aflB = new b.a((byte)0);
    AppMethodBeat.o(253175);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253142);
    AppMethodBeat.o(253142);
  }
  
  public final void initHeaderView()
  {
    AppMethodBeat.i(253185);
    super.initHeaderView();
    Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(com.tencent.mm.plugin.mvvmbase.a.a.class);
    s.s(localObject1, "UICProvider.of(activity)…ycleScopeUIC::class.java)");
    localObject1 = (com.tencent.mm.plugin.mvvmbase.a.a)localObject1;
    Object localObject2 = getStateCenter();
    if (localObject2 != null)
    {
      localObject2 = (com.tencent.mm.ui.mvvm.a.i)((UIStateCenter)localObject2).getState();
      if (localObject2 != null)
      {
        LifecycleScope.launchDefault$default(((com.tencent.mm.plugin.mvvmbase.a.a)localObject1).gsu(), null, (m)new b((com.tencent.mm.ui.mvvm.a.i)localObject2, (com.tencent.mm.plugin.mvvmbase.a.a)localObject1, this, null), 1, null);
        LifecycleScope.launchDefault$default(((com.tencent.mm.plugin.mvvmbase.a.a)localObject1).gsu(), null, (m)new c((com.tencent.mm.ui.mvvm.a.i)localObject2, (com.tencent.mm.plugin.mvvmbase.a.a)localObject1, this, null), 1, null);
        LifecycleScope.launchDefault$default(((com.tencent.mm.plugin.mvvmbase.a.a)localObject1).gsu(), null, (m)new d((com.tencent.mm.ui.mvvm.a.i)localObject2, (com.tencent.mm.plugin.mvvmbase.a.a)localObject1, this, null), 1, null);
        LifecycleScope.launchDefault$default(((com.tencent.mm.plugin.mvvmbase.a.a)localObject1).gsu(), null, (m)new e((com.tencent.mm.ui.mvvm.a.i)localObject2, (com.tencent.mm.plugin.mvvmbase.a.a)localObject1, this, null), 1, null);
      }
    }
    AppMethodBeat.o(253185);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    AppMethodBeat.i(253198);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(253198);
      return;
      paramIntent = paramIntent.getStringExtra("Select_Conv_User");
      s.checkNotNull(paramIntent);
      s.s(paramIntent, "data.getStringExtra(Cons…nversation.KSelectUser)!!");
      Object localObject = getStateCenter();
      if (localObject != null)
      {
        ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.h(p.listOf(paramIntent), paramInt1));
        AppMethodBeat.o(253198);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Conv_User");
        s.checkNotNull(paramIntent);
        s.s(paramIntent, "data.getStringExtra(Cons…nversation.KSelectUser)!!");
        paramIntent = n.a((CharSequence)paramIntent, new String[] { "," });
        if (!((Collection)paramIntent).isEmpty())
        {
          paramInt2 = i;
          label175:
          if (paramInt2 == 0) {
            break label223;
          }
        }
        while (paramIntent != null)
        {
          localObject = getStateCenter();
          if (localObject != null) {
            ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.ui.contact.select.a.a(paramIntent, paramInt1));
          }
          AppMethodBeat.o(253198);
          return;
          paramInt2 = 0;
          break label175;
          label223:
          paramIntent = null;
        }
        LinkedList localLinkedList1 = new LinkedList();
        LinkedList localLinkedList2 = new LinkedList();
        localObject = paramIntent.getStringExtra("Select_Contact");
        if (localObject != null)
        {
          localObject = n.b((CharSequence)localObject, new String[] { "," });
          if (((Collection)localObject).isEmpty()) {
            break label443;
          }
          paramInt2 = 1;
          label294:
          if (paramInt2 == 0) {
            break label448;
          }
          label298:
          if (localObject != null) {
            localLinkedList1.addAll((Collection)localObject);
          }
        }
        paramIntent = paramIntent.getStringExtra("Cancel_Select_Contact");
        if (paramIntent != null)
        {
          paramIntent = n.b((CharSequence)paramIntent, new String[] { "," });
          if (((Collection)paramIntent).isEmpty()) {
            break label454;
          }
          paramInt2 = 1;
          label357:
          if (paramInt2 == 0) {
            break label459;
          }
        }
        for (;;)
        {
          if (paramIntent != null) {
            localLinkedList2.addAll((Collection)paramIntent);
          }
          paramIntent = getStateCenter();
          if (paramIntent == null) {
            break;
          }
          paramIntent = (com.tencent.mm.ui.mvvm.a.i)paramIntent.getState();
          if (paramIntent == null) {
            break;
          }
          if (!paramIntent.gZe()) {
            break label464;
          }
          paramIntent = getStateCenter();
          if (paramIntent == null) {
            break label493;
          }
          paramIntent.dispatch((IStateAction)new com.tencent.mm.ui.contact.select.a.b((List)localLinkedList1, (List)localLinkedList2));
          AppMethodBeat.o(253198);
          return;
          label443:
          paramInt2 = 0;
          break label294;
          label448:
          localObject = null;
          break label298;
          label454:
          paramInt2 = 0;
          break label357;
          label459:
          paramIntent = null;
        }
        label464:
        paramIntent = getStateCenter();
        if (paramIntent != null) {
          paramIntent.dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.h((List)localLinkedList1, paramInt1));
        }
        label493:
        AppMethodBeat.o(253198);
        return;
        paramIntent = paramIntent.getStringExtra("Select_Contact");
        s.checkNotNull(paramIntent);
        s.s(paramIntent, "data.getStringExtra(Sele…Contact.KSelectContact)!!");
        localObject = getStateCenter();
        if (localObject != null) {
          ((UIStateCenter)localObject).dispatch((IStateAction)new com.tencent.mm.ui.mvvm.a.h(p.listOf(paramIntent), paramInt1));
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253178);
    super.onCreate(paramBundle);
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.process((q)getActivity(), (kotlin.g.a.b)b.f.aflE);
    }
    paramBundle = getStateCenter();
    if (paramBundle != null) {
      paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new g(this));
    }
    AppMethodBeat.o(253178);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(com.tencent.mm.ui.mvvm.a.i parami, com.tencent.mm.plugin.mvvmbase.a.a parama, b paramb, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(253152);
      paramObject = (d)new b(this.aflC, this.MfM, jdField_this, paramd);
      AppMethodBeat.o(253152);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(253146);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(253146);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if ((w.hasAttr(this.aflC.afhe, 256)) && (ab.bBP().size() > 0)) {
        j.a((aq)this.MfM.gsu(), (f)bg.kCh(), null, (m)new kotlin.d.b.a.k(jdField_this, this.aflC)
        {
          int label;
          
          private static final void a(b paramAnonymousb, com.tencent.mm.ui.mvvm.a.i paramAnonymousi, View paramAnonymousView)
          {
            AppMethodBeat.i(253106);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousb);
            localb.cH(paramAnonymousi);
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
            b.a(paramAnonymousb, paramAnonymousi);
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(253106);
          }
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(253124);
            paramAnonymousObject = (d)new 1(this.aflD, this.aflC, paramAnonymousd);
            AppMethodBeat.o(253124);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(253119);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(253119);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject = af.mU((Context)this.aflD.getActivity()).inflate(R.i.gkq, (ViewGroup)this.aflD.getRecyclerView(), false);
            TextView localTextView = (TextView)((View)localObject).findViewById(R.h.content_tv);
            if (this.aflC.afbe == 14) {}
            for (paramAnonymousObject = (CharSequence)this.aflD.getString(R.l.gqO);; paramAnonymousObject = (CharSequence)this.aflD.getString(R.l.gqB))
            {
              localTextView.setText(paramAnonymousObject);
              ((View)localObject).setOnClickListener(new b.b.1..ExternalSyntheticLambda0(this.aflD, this.aflC));
              paramAnonymousObject = (com.tencent.mm.view.recyclerview.i)this.aflD.fcp();
              s.s(localObject, "groupCardHeader");
              com.tencent.mm.view.recyclerview.i.a(paramAnonymousObject, (View)localObject, ((View)localObject).hashCode());
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(253119);
              return paramAnonymousObject;
            }
          }
        }, 2);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(253146);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(com.tencent.mm.ui.mvvm.a.i parami, com.tencent.mm.plugin.mvvmbase.a.a parama, b paramb, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(253157);
      paramObject = (d)new c(this.aflC, this.MfM, jdField_this, paramd);
      AppMethodBeat.o(253157);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(253150);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(253150);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (w.hasAttr(this.aflC.afhe, 512)) {
        j.a((aq)this.MfM.gsu(), (f)bg.kCh(), null, (m)new kotlin.d.b.a.k(jdField_this, null)
        {
          int label;
          
          private static final void a(b paramAnonymousb, View paramAnonymousView)
          {
            AppMethodBeat.i(253164);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousb);
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
            b.a(paramAnonymousb);
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$2$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(253164);
          }
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(253179);
            paramAnonymousObject = (d)new 1(this.aflD, paramAnonymousd);
            AppMethodBeat.o(253179);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(253176);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(253176);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = af.mU((Context)this.aflD.getActivity()).inflate(R.i.gkq, (ViewGroup)this.aflD.getRecyclerView(), false);
            ((TextView)paramAnonymousObject.findViewById(R.h.content_tv)).setText((CharSequence)this.aflD.getString(R.l.gHV));
            paramAnonymousObject.setOnClickListener(new b.c.1..ExternalSyntheticLambda0(this.aflD));
            localObject = (com.tencent.mm.view.recyclerview.i)this.aflD.fcp();
            s.s(paramAnonymousObject, "faceChatView");
            com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)localObject, paramAnonymousObject, paramAnonymousObject.hashCode());
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(253176);
            return paramAnonymousObject;
          }
        }, 2);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(253150);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(com.tencent.mm.ui.mvvm.a.i parami, com.tencent.mm.plugin.mvvmbase.a.a parama, b paramb, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(253163);
      paramObject = (d)new d(this.aflC, this.MfM, jdField_this, paramd);
      AppMethodBeat.o(253163);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(253155);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(253155);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (w.hasAttr(this.aflC.afhe, 2048)) {
        j.a((aq)this.MfM.gsu(), (f)bg.kCh(), null, (m)new kotlin.d.b.a.k(jdField_this, null)
        {
          int label;
          
          private static final void a(b paramAnonymousb, View paramAnonymousView)
          {
            AppMethodBeat.i(253112);
            Object localObject = new Object();
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousb);
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
            b.b(paramAnonymousb);
            com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$3$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(253112);
          }
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(253132);
            paramAnonymousObject = (d)new 1(this.aflD, paramAnonymousd);
            AppMethodBeat.o(253132);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(253128);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(253128);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = af.mU((Context)this.aflD.getActivity()).inflate(R.i.gkq, (ViewGroup)this.aflD.getRecyclerView(), false);
            ((TextView)paramAnonymousObject.findViewById(R.h.content_tv)).setText((CharSequence)this.aflD.getString(R.l.address_official_accounts_title));
            paramAnonymousObject.setOnClickListener(new b.d.1..ExternalSyntheticLambda0(this.aflD));
            localObject = (com.tencent.mm.view.recyclerview.i)this.aflD.fcp();
            s.s(paramAnonymousObject, "bizEntranceView");
            com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)localObject, paramAnonymousObject, paramAnonymousObject.hashCode());
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(253128);
            return paramAnonymousObject;
          }
        }, 2);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(253155);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(com.tencent.mm.ui.mvvm.a.i parami, com.tencent.mm.plugin.mvvmbase.a.a parama, b paramb, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(253169);
      paramObject = (d)new e(this.aflC, this.MfM, jdField_this, paramd);
      AppMethodBeat.o(253169);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(253162);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(253162);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (w.hasAttr(this.aflC.afhe, 16777216))
      {
        bh.bCz();
        if (c.bzA().iZS().size() > 0)
        {
          paramObject = ((e)com.tencent.mm.kernel.h.ax(e.class)).a("3552365301", "openim_acct_type_title", e.a.prb);
          j.a((aq)this.MfM.gsu(), (f)bg.kCh(), null, (m)new kotlin.d.b.a.k(jdField_this, paramObject)
          {
            int label;
            
            private static final void a(b paramAnonymousb, com.tencent.mm.ui.mvvm.a.i paramAnonymousi, View paramAnonymousView)
            {
              AppMethodBeat.i(253181);
              Object localObject = new Object();
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousb);
              localb.cH(paramAnonymousi);
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
              b.b(paramAnonymousb, paramAnonymousi);
              com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/ui/contact/select/uic/SelectContactLiveListUIC$initHeaderView$1$4$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(253181);
            }
            
            public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
            {
              AppMethodBeat.i(253214);
              paramAnonymousObject = (d)new 1(this.aflD, paramObject, this.aflC, paramAnonymousd);
              AppMethodBeat.o(253214);
              return paramAnonymousObject;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(253205);
              Object localObject = kotlin.d.a.a.aiwj;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(253205);
                throw paramAnonymousObject;
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = af.mU((Context)this.aflD.getActivity()).inflate(R.i.gkq, (ViewGroup)this.aflD.getRecyclerView(), false);
              ((TextView)paramAnonymousObject.findViewById(R.h.content_tv)).setText((CharSequence)paramObject);
              paramAnonymousObject.setOnClickListener(new b.e.1..ExternalSyntheticLambda0(this.aflD, this.aflC));
              localObject = (com.tencent.mm.view.recyclerview.i)this.aflD.fcp();
              s.s(paramAnonymousObject, "openIMHeader");
              com.tencent.mm.view.recyclerview.i.a((com.tencent.mm.view.recyclerview.i)localObject, paramAnonymousObject, paramAnonymousObject.hashCode());
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(253205);
              return paramAnonymousObject;
            }
          }, 2);
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(253162);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/ui/mvvm/state/SelectContactState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.mvvm.a.i, ah>
  {
    g(b paramb)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.ui.mvvm.item.b>, ah>
    {
      a(com.tencent.mm.ui.mvvm.a.i parami)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/tencent/mm/ui/mvvm/item/SelectContactLiveItem;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.b<ArrayList<com.tencent.mm.ui.mvvm.item.b>, ah>
    {
      b(com.tencent.mm.ui.mvvm.a.i parami)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.select.b.b
 * JD-Core Version:    0.7.0.1
 */