package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejd
  extends dop
{
  public String Nbu;
  public String Nbv;
  public String Nbw;
  public String dPr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129977);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Nbv != null) {
        paramVarArgs.e(2, this.Nbv);
      }
      if (this.Nbu != null) {
        paramVarArgs.e(3, this.Nbu);
      }
      if (this.Nbw != null) {
        paramVarArgs.e(4, this.Nbw);
      }
      if (this.dPr != null) {
        paramVarArgs.e(5, this.dPr);
      }
      AppMethodBeat.o(129977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nbv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nbv);
      }
      i = paramInt;
      if (this.Nbu != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Nbu);
      }
      paramInt = i;
      if (this.Nbw != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nbw);
      }
      i = paramInt;
      if (this.dPr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dPr);
      }
      AppMethodBeat.o(129977);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(129977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejd localejd = (ejd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129977);
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
            localejd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(129977);
          return 0;
        case 2: 
          localejd.Nbv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 3: 
          localejd.Nbu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 4: 
          localejd.Nbw = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(129977);
          return 0;
        }
        localejd.dPr = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(129977);
        return 0;
      }
      AppMethodBeat.o(129977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejd
 * JD-Core Version:    0.7.0.1
 */