package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dfh
  extends dop
{
  public String MKj;
  public String MKk;
  public String MKl;
  public String MKm;
  public String MKn;
  public int MKo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.MKj != null) {
        paramVarArgs.e(2, this.MKj);
      }
      if (this.MKk != null) {
        paramVarArgs.e(3, this.MKk);
      }
      if (this.MKl != null) {
        paramVarArgs.e(4, this.MKl);
      }
      if (this.MKm != null) {
        paramVarArgs.e(5, this.MKm);
      }
      if (this.MKn != null) {
        paramVarArgs.e(6, this.MKn);
      }
      paramVarArgs.aM(7, this.MKo);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label671;
      }
    }
    label671:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MKj != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MKj);
      }
      i = paramInt;
      if (this.MKk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MKk);
      }
      paramInt = i;
      if (this.MKl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MKl);
      }
      i = paramInt;
      if (this.MKm != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MKm);
      }
      paramInt = i;
      if (this.MKn != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MKn);
      }
      i = g.a.a.b.b.a.bu(7, this.MKo);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dfh localdfh = (dfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
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
            localdfh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localdfh.MKj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localdfh.MKk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localdfh.MKl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localdfh.MKm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localdfh.MKn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localdfh.MKo = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfh
 * JD-Core Version:    0.7.0.1
 */