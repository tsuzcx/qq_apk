package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cn
  extends dop
{
  public b KGH;
  public int KGI;
  public String dNI;
  public String fileid;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.e(2, this.nickname);
      }
      if (this.KGH != null) {
        paramVarArgs.c(3, this.KGH);
      }
      if (this.fileid != null) {
        paramVarArgs.e(4, this.fileid);
      }
      paramVarArgs.aM(5, this.KGI);
      if (this.dNI != null) {
        paramVarArgs.e(6, this.dNI);
      }
      AppMethodBeat.o(152481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.nickname);
      }
      i = paramInt;
      if (this.KGH != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.KGH);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.fileid);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KGI);
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dNI);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cn localcn = (cn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
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
            localcn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localcn.nickname = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localcn.KGH = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localcn.fileid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localcn.KGI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152481);
          return 0;
        }
        localcn.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cn
 * JD-Core Version:    0.7.0.1
 */