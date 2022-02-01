package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cjq
  extends erp
{
  public String aasl;
  public b aasm;
  public int live_type;
  public int scene;
  public String xlr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104369);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.scene);
      if (this.xlr != null) {
        paramVarArgs.g(3, this.xlr);
      }
      if (this.aasl != null) {
        paramVarArgs.g(4, this.aasl);
      }
      paramVarArgs.bS(5, this.live_type);
      if (this.aasm != null) {
        paramVarArgs.d(6, this.aasm);
      }
      AppMethodBeat.o(104369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.scene);
      paramInt = i;
      if (this.xlr != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.xlr);
      }
      i = paramInt;
      if (this.aasl != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aasl);
      }
      i += i.a.a.b.b.a.cJ(5, this.live_type);
      paramInt = i;
      if (this.aasm != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.aasm);
      }
      AppMethodBeat.o(104369);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104369);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cjq localcjq = (cjq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104369);
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
            localcjq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(104369);
          return 0;
        case 2: 
          localcjq.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104369);
          return 0;
        case 3: 
          localcjq.xlr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104369);
          return 0;
        case 4: 
          localcjq.aasl = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(104369);
          return 0;
        case 5: 
          localcjq.live_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(104369);
          return 0;
        }
        localcjq.aasm = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(104369);
        return 0;
      }
      AppMethodBeat.o(104369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjq
 * JD-Core Version:    0.7.0.1
 */