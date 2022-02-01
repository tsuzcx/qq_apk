package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtg
  extends com.tencent.mm.bw.a
{
  public String GwG;
  public String GwH;
  public String GwI;
  public com.tencent.mm.bw.b HYV;
  public boolean HYW;
  public LinkedList<String> HYX;
  public String HYY;
  public String MD5;
  public int xsB;
  public int xsC;
  
  public dtg()
  {
    AppMethodBeat.i(104839);
    this.HYX = new LinkedList();
    AppMethodBeat.o(104839);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104840);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HYV == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(104840);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.HYV != null) {
        paramVarArgs.c(4, this.HYV);
      }
      paramVarArgs.bC(5, this.HYW);
      paramVarArgs.e(6, 1, this.HYX);
      if (this.GwG != null) {
        paramVarArgs.d(7, this.GwG);
      }
      if (this.HYY != null) {
        paramVarArgs.d(8, this.HYY);
      }
      if (this.GwI != null) {
        paramVarArgs.d(9, this.GwI);
      }
      if (this.GwH != null) {
        paramVarArgs.d(10, this.GwH);
      }
      AppMethodBeat.o(104840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label754;
      }
    }
    label754:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.HYV != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.HYV);
      }
      i = paramInt + f.a.a.b.b.a.amF(5) + f.a.a.a.c(6, 1, this.HYX);
      paramInt = i;
      if (this.GwG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GwG);
      }
      i = paramInt;
      if (this.HYY != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HYY);
      }
      paramInt = i;
      if (this.GwI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GwI);
      }
      i = paramInt;
      if (this.GwH != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.GwH);
      }
      AppMethodBeat.o(104840);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HYX.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HYV == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(104840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104840);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtg localdtg = (dtg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104840);
          return -1;
        case 1: 
          localdtg.MD5 = locala.OmT.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 2: 
          localdtg.xsC = locala.OmT.zc();
          AppMethodBeat.o(104840);
          return 0;
        case 3: 
          localdtg.xsB = locala.OmT.zc();
          AppMethodBeat.o(104840);
          return 0;
        case 4: 
          localdtg.HYV = locala.OmT.gCk();
          AppMethodBeat.o(104840);
          return 0;
        case 5: 
          localdtg.HYW = locala.OmT.gvY();
          AppMethodBeat.o(104840);
          return 0;
        case 6: 
          localdtg.HYX.add(locala.OmT.readString());
          AppMethodBeat.o(104840);
          return 0;
        case 7: 
          localdtg.GwG = locala.OmT.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 8: 
          localdtg.HYY = locala.OmT.readString();
          AppMethodBeat.o(104840);
          return 0;
        case 9: 
          localdtg.GwI = locala.OmT.readString();
          AppMethodBeat.o(104840);
          return 0;
        }
        localdtg.GwH = locala.OmT.readString();
        AppMethodBeat.o(104840);
        return 0;
      }
      AppMethodBeat.o(104840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtg
 * JD-Core Version:    0.7.0.1
 */