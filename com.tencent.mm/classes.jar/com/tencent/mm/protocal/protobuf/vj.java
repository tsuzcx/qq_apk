package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vj
  extends cpx
{
  public String EpB;
  public int EpC;
  public String fileid;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9588);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null)
      {
        paramVarArgs = new b("Not all required fields were included: fileid");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.d(2, this.fileid);
      }
      if (this.md5 != null) {
        paramVarArgs.d(3, this.md5);
      }
      if (this.EpB != null) {
        paramVarArgs.d(4, this.EpB);
      }
      paramVarArgs.aR(5, this.EpC);
      AppMethodBeat.o(9588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label645;
      }
    }
    label645:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.fileid);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.md5);
      }
      paramInt = i;
      if (this.EpB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EpB);
      }
      i = f.a.a.b.b.a.bx(5, this.EpC);
      AppMethodBeat.o(9588);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.fileid == null)
        {
          paramVarArgs = new b("Not all required fields were included: fileid");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9588);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vj localvj = (vj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9588);
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
            localvj.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(9588);
          return 0;
        case 2: 
          localvj.fileid = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 3: 
          localvj.md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 4: 
          localvj.EpB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(9588);
          return 0;
        }
        localvj.EpC = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(9588);
        return 0;
      }
      AppMethodBeat.o(9588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vj
 * JD-Core Version:    0.7.0.1
 */