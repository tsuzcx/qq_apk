package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fj
  extends dop
{
  public LinkedList<acd> KII;
  public int KIJ;
  public int KIK;
  public String session_id;
  public String url;
  
  public fj()
  {
    AppMethodBeat.i(103186);
    this.KII = new LinkedList();
    AppMethodBeat.o(103186);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103187);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      paramVarArgs.e(4, 8, this.KII);
      if (this.session_id != null) {
        paramVarArgs.e(5, this.session_id);
      }
      paramVarArgs.aM(6, this.KIJ);
      paramVarArgs.aM(7, this.KIK);
      AppMethodBeat.o(103187);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.url);
      }
      i += g.a.a.a.c(4, 8, this.KII);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.session_id);
      }
      i = g.a.a.b.b.a.bu(6, this.KIJ);
      int j = g.a.a.b.b.a.bu(7, this.KIK);
      AppMethodBeat.o(103187);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KII.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103187);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103187);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 2: 
          localfj.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfj.KII.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103187);
          return 0;
        case 5: 
          localfj.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103187);
          return 0;
        case 6: 
          localfj.KIJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103187);
          return 0;
        }
        localfj.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(103187);
        return 0;
      }
      AppMethodBeat.o(103187);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */