package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cw
  extends erp
{
  public b YFd;
  public int YFe;
  public String appid;
  public String fileid;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152481);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.g(2, this.nickname);
      }
      if (this.YFd != null) {
        paramVarArgs.d(3, this.YFd);
      }
      if (this.fileid != null) {
        paramVarArgs.g(4, this.fileid);
      }
      paramVarArgs.bS(5, this.YFe);
      if (this.appid != null) {
        paramVarArgs.g(6, this.appid);
      }
      AppMethodBeat.o(152481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nickname);
      }
      i = paramInt;
      if (this.YFd != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YFd);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.fileid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YFe);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.appid);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cw localcw = (cw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localcw.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localcw.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localcw.YFd = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localcw.fileid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localcw.YFe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(152481);
          return 0;
        }
        localcw.appid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cw
 * JD-Core Version:    0.7.0.1
 */