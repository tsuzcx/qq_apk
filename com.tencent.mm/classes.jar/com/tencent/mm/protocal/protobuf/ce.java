package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ce
  extends cpx
{
  public b DPu;
  public int DPv;
  public String djj;
  public String fileid;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.DPu != null) {
        paramVarArgs.c(3, this.DPu);
      }
      if (this.fileid != null) {
        paramVarArgs.d(4, this.fileid);
      }
      paramVarArgs.aR(5, this.DPv);
      if (this.djj != null) {
        paramVarArgs.d(6, this.djj);
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
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.DPu != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.DPu);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fileid);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.DPv);
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.djj);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localce.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localce.nickname = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localce.DPu = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localce.fileid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localce.DPv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152481);
          return 0;
        }
        localce.djj = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */