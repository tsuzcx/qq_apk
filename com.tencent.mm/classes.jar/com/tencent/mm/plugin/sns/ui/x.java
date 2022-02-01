package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract interface x
{
  public abstract void clean();
  
  public abstract View getView();
  
  public abstract void setImageClick(a parama);
  
  public abstract void setIsShowAddImage(boolean paramBoolean);
  
  public abstract void setList$22875ea3(List<String> paramList);
  
  public static abstract class a
  {
    public View.OnClickListener yAf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(97924);
        if (paramAnonymousView.getTag() == null)
        {
          AppMethodBeat.o(97924);
          return;
        }
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        x.a.this.Ld(i);
        AppMethodBeat.o(97924);
      }
    };
    
    public abstract void Ld(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.x
 * JD-Core Version:    0.7.0.1
 */