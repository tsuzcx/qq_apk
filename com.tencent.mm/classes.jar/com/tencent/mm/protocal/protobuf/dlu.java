package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dlu
  extends dop
{
  public String HuS;
  public String Lmm;
  public int MJd;
  public String MJh;
  public String MJi;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MJd);
      if (this.MJi != null) {
        paramVarArgs.e(3, this.MJi);
      }
      if (this.Lmm != null) {
        paramVarArgs.e(4, this.Lmm);
      }
      paramVarArgs.aM(5, this.yba);
      if (this.MJh != null) {
        paramVarArgs.e(6, this.MJh);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label666;
      }
    }
    label666:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MJd);
      paramInt = i;
      if (this.MJi != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MJi);
      }
      i = paramInt;
      if (this.Lmm != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.Lmm);
      }
      i += g.a.a.b.b.a.bu(5, this.yba);
      paramInt = i;
      if (this.MJh != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MJh);
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dlu localdlu = (dlu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdlu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localdlu.MJd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localdlu.MJi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localdlu.Lmm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localdlu.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localdlu.MJh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localdlu.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlu
 * JD-Core Version:    0.7.0.1
 */