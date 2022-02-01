package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cvp;
import java.util.LinkedList;

public final class ap
  extends cvp
{
  public int channel;
  public String fileid;
  public boolean xdi;
  public String xdj;
  public String xdk;
  public int xdl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215232);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.d(2, this.fileid);
      }
      paramVarArgs.bt(3, this.xdi);
      if (this.xdj != null) {
        paramVarArgs.d(4, this.xdj);
      }
      if (this.xdk != null) {
        paramVarArgs.d(5, this.xdk);
      }
      paramVarArgs.aS(6, this.xdl);
      paramVarArgs.aS(7, this.channel);
      AppMethodBeat.o(215232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fileid != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.fileid);
      }
      i += f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.xdj != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.xdj);
      }
      i = paramInt;
      if (this.xdk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.xdk);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.xdl);
      int j = f.a.a.b.b.a.bz(7, this.channel);
      AppMethodBeat.o(215232);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(215232);
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
          AppMethodBeat.o(215232);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localap.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215232);
          return 0;
        case 2: 
          localap.fileid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215232);
          return 0;
        case 3: 
          localap.xdi = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(215232);
          return 0;
        case 4: 
          localap.xdj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215232);
          return 0;
        case 5: 
          localap.xdk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(215232);
          return 0;
        case 6: 
          localap.xdl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(215232);
          return 0;
        }
        localap.channel = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(215232);
        return 0;
      }
      AppMethodBeat.o(215232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ap
 * JD-Core Version:    0.7.0.1
 */