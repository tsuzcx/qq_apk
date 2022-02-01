package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class chm
  extends com.tencent.mm.bw.a
{
  public double Gax;
  public double Gay;
  public String Guh;
  public String Gui;
  public String HtG;
  public String HtH;
  public String HtI;
  public String HtJ;
  public String Name;
  public String jfW;
  public String jfX;
  public String wFC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56257);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Name != null) {
        paramVarArgs.d(1, this.Name);
      }
      if (this.HtG != null) {
        paramVarArgs.d(2, this.HtG);
      }
      paramVarArgs.e(3, this.Gax);
      paramVarArgs.e(4, this.Gay);
      if (this.HtH != null) {
        paramVarArgs.d(5, this.HtH);
      }
      if (this.wFC != null) {
        paramVarArgs.d(6, this.wFC);
      }
      if (this.HtI != null) {
        paramVarArgs.d(7, this.HtI);
      }
      if (this.jfW != null) {
        paramVarArgs.d(8, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(9, this.jfX);
      }
      if (this.Guh != null) {
        paramVarArgs.d(10, this.Guh);
      }
      if (this.Gui != null) {
        paramVarArgs.d(11, this.Gui);
      }
      if (this.HtJ != null) {
        paramVarArgs.d(12, this.HtJ);
      }
      AppMethodBeat.o(56257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Name == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = f.a.a.b.b.a.e(1, this.Name) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HtG != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HtG);
      }
      i = i + f.a.a.b.b.a.amD(3) + f.a.a.b.b.a.amD(4);
      paramInt = i;
      if (this.HtH != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HtH);
      }
      i = paramInt;
      if (this.wFC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.wFC);
      }
      paramInt = i;
      if (this.HtI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HtI);
      }
      i = paramInt;
      if (this.jfW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.jfW);
      }
      paramInt = i;
      if (this.jfX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.jfX);
      }
      i = paramInt;
      if (this.Guh != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Guh);
      }
      paramInt = i;
      if (this.Gui != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Gui);
      }
      i = paramInt;
      if (this.HtJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HtJ);
      }
      AppMethodBeat.o(56257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(56257);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chm localchm = (chm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56257);
          return -1;
        case 1: 
          localchm.Name = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 2: 
          localchm.HtG = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 3: 
          localchm.Gax = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(56257);
          return 0;
        case 4: 
          localchm.Gay = Double.longBitsToDouble(locala.OmT.gwc());
          AppMethodBeat.o(56257);
          return 0;
        case 5: 
          localchm.HtH = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 6: 
          localchm.wFC = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 7: 
          localchm.HtI = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 8: 
          localchm.jfW = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 9: 
          localchm.jfX = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 10: 
          localchm.Guh = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        case 11: 
          localchm.Gui = locala.OmT.readString();
          AppMethodBeat.o(56257);
          return 0;
        }
        localchm.HtJ = locala.OmT.readString();
        AppMethodBeat.o(56257);
        return 0;
      }
      AppMethodBeat.o(56257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chm
 * JD-Core Version:    0.7.0.1
 */