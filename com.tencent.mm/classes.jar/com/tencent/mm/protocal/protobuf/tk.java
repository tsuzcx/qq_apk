package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tk
  extends com.tencent.mm.bw.a
{
  public int Gjq;
  public String Gjr;
  public String Gjs;
  public String Gjt;
  public int Gju;
  public String Gjv;
  public ti Gjw;
  public String Gjx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gjq);
      if (this.Gjr != null) {
        paramVarArgs.d(2, this.Gjr);
      }
      if (this.Gjs != null) {
        paramVarArgs.d(3, this.Gjs);
      }
      if (this.Gjt != null) {
        paramVarArgs.d(4, this.Gjt);
      }
      paramVarArgs.aS(5, this.Gju);
      if (this.Gjv != null) {
        paramVarArgs.d(6, this.Gjv);
      }
      if (this.Gjw != null)
      {
        paramVarArgs.lJ(7, this.Gjw.computeSize());
        this.Gjw.writeFields(paramVarArgs);
      }
      if (this.Gjx != null) {
        paramVarArgs.d(8, this.Gjx);
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Gjq) + 0;
      paramInt = i;
      if (this.Gjr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gjr);
      }
      i = paramInt;
      if (this.Gjs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gjs);
      }
      paramInt = i;
      if (this.Gjt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gjt);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.Gju);
      paramInt = i;
      if (this.Gjv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gjv);
      }
      i = paramInt;
      if (this.Gjw != null) {
        i = paramInt + f.a.a.a.lI(7, this.Gjw.computeSize());
      }
      paramInt = i;
      if (this.Gjx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gjx);
      }
      AppMethodBeat.o(113967);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(113967);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      tk localtk = (tk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113967);
        return -1;
      case 1: 
        localtk.Gjq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113967);
        return 0;
      case 2: 
        localtk.Gjr = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 3: 
        localtk.Gjs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 4: 
        localtk.Gjt = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 5: 
        localtk.Gju = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(113967);
        return 0;
      case 6: 
        localtk.Gjv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(113967);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ti();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ti)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localtk.Gjw = ((ti)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113967);
        return 0;
      }
      localtk.Gjx = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(113967);
      return 0;
    }
    AppMethodBeat.o(113967);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tk
 * JD-Core Version:    0.7.0.1
 */