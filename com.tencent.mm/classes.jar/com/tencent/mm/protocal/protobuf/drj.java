package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drj
  extends erp
{
  public String Okt;
  public String aaXg;
  public long ihV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260261);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Okt != null) {
        paramVarArgs.g(2, this.Okt);
      }
      paramVarArgs.bv(3, this.ihV);
      if (this.aaXg != null) {
        paramVarArgs.g(4, this.aaXg);
      }
      AppMethodBeat.o(260261);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Okt != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Okt);
      }
      i += i.a.a.b.b.a.q(3, this.ihV);
      paramInt = i;
      if (this.aaXg != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaXg);
      }
      AppMethodBeat.o(260261);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260261);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        drj localdrj = (drj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260261);
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
            localdrj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(260261);
          return 0;
        case 2: 
          localdrj.Okt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260261);
          return 0;
        case 3: 
          localdrj.ihV = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(260261);
          return 0;
        }
        localdrj.aaXg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260261);
        return 0;
      }
      AppMethodBeat.o(260261);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drj
 * JD-Core Version:    0.7.0.1
 */