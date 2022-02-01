package com.tencent.mm.plugin.recordvideo.plugin;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.f.c;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorInputView.c;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseIconPlugin;", "parent", "Landroid/view/ViewGroup;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "inputPanel", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorInputView;)V", "addTextBtn", "Landroid/widget/ImageView;", "caption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "changeText", "", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "editText", "", "text", "", "color", "", "bgColor", "font", "", "enableSelectFont", "enable", "initSafeArea", "onBackPress", "onClick", "v", "Landroid/view/View;", "resetConfirmStyle", "bgStyleResId", "textColor", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "resetIconColor", "iconColor", "setVisibility", "visibility", "showEditTextPanel", "updateCaption", "transResult", "", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
  implements View.OnClickListener
{
  private static final e.a NJG;
  public EditorInputView NJH;
  private final ImageView NJI;
  private boolean NJJ;
  private final uq NJK;
  private ViewGroup parent;
  
  static
  {
    AppMethodBeat.i(280523);
    NJG = new e.a((byte)0);
    AppMethodBeat.o(280523);
  }
  
  public e(ViewGroup paramViewGroup, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama, EditorInputView paramEditorInputView)
  {
    super(parama);
    AppMethodBeat.i(75473);
    this.parent = paramViewGroup;
    this.NJH = paramEditorInputView;
    paramViewGroup = this.parent.findViewById(b.e.editor_add_text);
    s.s(paramViewGroup, "parent.findViewById(R.id.editor_add_text)");
    this.NJI = ((ImageView)paramViewGroup);
    this.NJK = new uq();
    this.NJI.setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_text, -1));
    this.NJI.setOnClickListener((View.OnClickListener)this);
    this.NJH.setConfirmBtnBg(b.d.story_green_btn);
    this.NJH.setOnVisibleChangeCallback((kotlin.g.a.b)new u(parama) {});
    this.NJH.setTextCallback((EditorInputView.a)new EditorInputView.a()
    {
      public final void b(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString)
      {
        AppMethodBeat.i(280739);
        s.u(paramAnonymousString, "font");
        if (paramAnonymousCharSequence != null) {
          if (paramAnonymousCharSequence.length() != 0) {
            break label50;
          }
        }
        label50:
        for (int i = 1; i != 0; i = 0)
        {
          e.a(this.NJM).setShow(false);
          AppMethodBeat.o(280739);
          return;
        }
        Bundle localBundle = new Bundle();
        switch (e.a(this.NJM).getMode())
        {
        }
        for (;;)
        {
          e.a(this.NJM).setShow(false);
          AppMethodBeat.o(280739);
          return;
          localBundle.putCharSequence("PARAM_EDIT_TEXT_CONTENT", (CharSequence)paramAnonymousCharSequence.toString());
          localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramAnonymousInt1);
          localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramAnonymousInt2);
          localBundle.putString("PARAM_EDIT_TEXT_FONT", paramAnonymousString);
          parama.a(a.c.NOr, localBundle);
          continue;
          uq localuq = e.b(this.NJM);
          paramAnonymousCharSequence = paramAnonymousCharSequence.toString();
          Charset localCharset = d.UTF_8;
          if (paramAnonymousCharSequence == null)
          {
            paramAnonymousCharSequence = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(280739);
            throw paramAnonymousCharSequence;
          }
          paramAnonymousCharSequence = paramAnonymousCharSequence.getBytes(localCharset);
          s.s(paramAnonymousCharSequence, "(this as java.lang.String).getBytes(charset)");
          localuq.YZW = new com.tencent.mm.bx.b(paramAnonymousCharSequence);
          localBundle.putByteArray("PARAM_1_BYTEARRAY", e.b(this.NJM).toByteArray());
          localBundle.putLong("PARAM_1_LONG", e.b(this.NJM).YZX);
          localBundle.putInt("PARAM_EDIT_TEXT_COLOR", paramAnonymousInt1);
          localBundle.putInt("PARAM_EDIT_TEXT_COLOR_BG_INT", paramAnonymousInt2);
          localBundle.putString("PARAM_EDIT_TEXT_FONT", paramAnonymousString);
          parama.a(a.c.NPN, localBundle);
        }
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(75467);
        e.a(this.NJM).setShow(false);
        switch (e.a(this.NJM).getMode())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(75467);
          return;
          a.b.a(parama, a.c.NPP);
          AppMethodBeat.o(75467);
          return;
          a.b.a(parama, a.c.NOM);
          a.b.a(parama, a.c.NOt);
        }
      }
    });
    paramViewGroup = bf.bf(this.parent.getContext());
    int i = paramViewGroup.y;
    int j = paramViewGroup.x;
    float f1 = i / j;
    float f2 = i / 2.18F;
    f2 = (j - f2) / 2.0F;
    if ((f1 <= 1.78F) || (f1 < 2.18F)) {
      this.NJH.cV(f2);
    }
    AppMethodBeat.o(75473);
  }
  
  public final void a(CharSequence paramCharSequence, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(280527);
    this.NJJ = true;
    this.NJH.mode = 0;
    this.NJH.setShow(true);
    this.NJH.setTypeFace(paramString);
    this.NJH.e(paramCharSequence, paramInt1, paramInt2);
    AppMethodBeat.o(280527);
  }
  
  public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(280537);
    s.u(paramArrayOfByte, "transResult");
    try
    {
      com.tencent.mm.bx.a locala = (com.tencent.mm.bx.a)new uq();
      try
      {
        locala.parseFrom(paramArrayOfByte);
        paramArrayOfByte = locala;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { paramArrayOfByte });
          paramArrayOfByte = null;
        }
      }
      paramArrayOfByte = (uq)paramArrayOfByte;
      if (paramArrayOfByte != null)
      {
        this.NJJ = true;
        this.NJK.id = paramArrayOfByte.id;
        this.NJK.YZW = paramArrayOfByte.YZW;
        this.NJK.YZX = paramArrayOfByte.YZX;
        this.NJK.YZY = paramArrayOfByte.YZY;
        this.NJH.mode = 2;
        this.NJH.setShow(true);
        this.NJH.setTypeFace(paramString);
        this.NJH.e((CharSequence)paramArrayOfByte.YZW.ZV(), paramInt1, paramInt2);
        AppMethodBeat.o(280537);
        return;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      com.tencent.mm.audio.mix.h.b.printErrStackTrace("MicroMsg.EditAddTextPlugin", (Throwable)paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(280537);
    }
  }
  
  public final void agy(int paramInt)
  {
    AppMethodBeat.i(280576);
    this.NJI.setImageDrawable(bb.m(this.parent.getContext(), b.g.icons_filled_text, paramInt));
    AppMethodBeat.o(280576);
  }
  
  public final void c(Integer paramInteger1, Integer paramInteger2)
  {
    AppMethodBeat.i(75469);
    View localView = this.NJH.getConfirm();
    if ((paramInteger1 != null) && (paramInteger1.intValue() != 0)) {
      localView.setBackgroundResource(paramInteger1.intValue());
    }
    if ((paramInteger2 != null) && (paramInteger2.intValue() != 0) && ((localView instanceof TextView))) {
      ((TextView)localView).setTextColor(androidx.core.content.a.w(((TextView)localView).getContext(), paramInteger2.intValue()));
    }
    AppMethodBeat.o(75469);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(280560);
    this.NJI.performClick();
    AppMethodBeat.o(280560);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(75472);
    if (this.NJH.cvt())
    {
      this.NJH.cancel();
      this.NJH.setShow(false);
      AppMethodBeat.o(75472);
      return true;
    }
    AppMethodBeat.o(75472);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(75470);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    this.NJH.mode = 0;
    this.NJH.setShow(true);
    paramView = this.NJH;
    localObject = (CharSequence)"";
    EditorInputView.c localc = EditorInputView.NVB;
    paramView.e((CharSequence)localObject, EditorInputView.gKe(), 0);
    paramView = c.NRf;
    c.aTg("KEY_CLICK_TEXT_COUNT_INT");
    paramView = c.NRf;
    c.agG(5);
    paramView = c.NRf;
    c.agH(8);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/plugin/EditAddTextPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(75470);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(75471);
    super.setVisibility(paramInt);
    this.NJI.setVisibility(paramInt);
    AppMethodBeat.o(75471);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.e
 * JD-Core Version:    0.7.0.1
 */