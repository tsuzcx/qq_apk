package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cwj;
import java.util.LinkedList;

public final class ap
  extends cwj
{
  public int channel;
  public String fileid;
  public boolean xsZ;
  public String xta;
  public String xtb;
  public int xtc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(217978);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.d(2, this.fileid);
      }
      paramVarArgs.bC(3, this.xsZ);
      if (this.xta != null) {
        paramVarArgs.d(4, this.xta);
      }
      if (this.xtb != null) {
        paramVarArgs.d(5, this.xtb);
      }
      paramVarArgs.aS(6, this.xtc);
      paramVarArgs.aS(7, this.channel);
      AppMethodBeat.o(217978);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fileid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fileid);
      }
      i += f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.xta != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xta);
      }
      i = paramInt;
      if (this.xtb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xtb);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.xtc);
      int j = f.a.a.b.b.a.bz(7, this.channel);
      AppMethodBeat.o(217978);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(217978);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(217978);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localap.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(217978);
          return 0;
        case 2: 
          localap.fileid = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217978);
          return 0;
        case 3: 
          localap.xsZ = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(217978);
          return 0;
        case 4: 
          localap.xta = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217978);
          return 0;
        case 5: 
          localap.xtb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(217978);
          return 0;
        case 6: 
          localap.xtc = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(217978);
          return 0;
        }
        localap.channel = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(217978);
        return 0;
      }
      AppMethodBeat.o(217978);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ap
 * JD-Core Version:    0.7.0.1
 */