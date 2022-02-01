package com.tencent.mm.ui.vas.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/api/IVASController;", "", "isRemoveContainerMargin", "", "className", "", "isSupportVAS", "isSwitchOpen", "setSwitchOpen", "", "open", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface a
{
  public static final a afQX = a.afQY;
  
  public abstract boolean aVy(String paramString);
  
  public abstract boolean aVz(String paramString);
  
  public abstract boolean gUR();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/vas/api/IVASController$Companion;", "", "()V", "DEF", "Lcom/tencent/mm/ui/vas/api/IVASController;", "getDEF", "()Lcom/tencent/mm/ui/vas/api/IVASController;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final a afQZ;
    
    static
    {
      AppMethodBeat.i(249997);
      afQY = new a();
      afQZ = (a)new a();
      AppMethodBeat.o(249997);
    }
    
    public static a jEr()
    {
      return afQZ;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/ui/vas/api/IVASController$Companion$DEF$1", "Lcom/tencent/mm/ui/vas/api/IVASController;", "isRemoveContainerMargin", "", "className", "", "isSupportVAS", "isSwitchOpen", "setSwitchOpen", "", "open", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements a
    {
      public final boolean aVy(String paramString)
      {
        return false;
      }
      
      public final boolean aVz(String paramString)
      {
        return false;
      }
      
      public final boolean gUR()
      {
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.vas.b.a
 * JD-Core Version:    0.7.0.1
 */