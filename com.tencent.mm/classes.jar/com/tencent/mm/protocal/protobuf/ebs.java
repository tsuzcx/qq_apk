package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebs
  extends dop
{
  public String MBA;
  public int Nbr;
  public int Nbs;
  public String Nbu;
  public String dPr;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91698);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MBA != null) {
        paramVarArgs.e(2, this.MBA);
      }
      if (this.signature != null) {
        paramVarArgs.e(3, this.signature);
      }
      if (this.Nbu != null) {
        paramVarArgs.e(4, this.Nbu);
      }
      if (this.dPr != null) {
        paramVarArgs.e(5, this.dPr);
      }
      paramVarArgs.aM(6, this.Nbr);
      paramVarArgs.aM(7, this.Nbs);
      AppMethodBeat.o(91698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MBA != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MBA);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.signature);
      }
      paramInt = i;
      if (this.Nbu != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nbu);
      }
      i = paramInt;
      if (this.dPr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dPr);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.Nbr);
      int j = g.a.a.b.b.a.bu(7, this.Nbs);
      AppMethodBeat.o(91698);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebs localebs = (ebs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91698);
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
            localebs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91698);
          return 0;
        case 2: 
          localebs.MBA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 3: 
          localebs.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 4: 
          localebs.Nbu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 5: 
          localebs.dPr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 6: 
          localebs.Nbr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91698);
          return 0;
        }
        localebs.Nbs = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91698);
        return 0;
      }
      AppMethodBeat.o(91698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebs
 * JD-Core Version:    0.7.0.1
 */