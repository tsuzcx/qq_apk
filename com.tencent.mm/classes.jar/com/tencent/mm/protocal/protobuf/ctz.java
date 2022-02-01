package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctz
  extends erp
{
  public String YEY;
  public String YEv;
  public String extInfo;
  public int scene;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257832);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uxInfo != null) {
        paramVarArgs.g(2, this.uxInfo);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.YEv != null) {
        paramVarArgs.g(4, this.YEv);
      }
      if (this.YEY != null) {
        paramVarArgs.g(5, this.YEY);
      }
      if (this.extInfo != null) {
        paramVarArgs.g(6, this.extInfo);
      }
      AppMethodBeat.o(257832);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uxInfo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.uxInfo);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.YEv != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YEv);
      }
      i = paramInt;
      if (this.YEY != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YEY);
      }
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.extInfo);
      }
      AppMethodBeat.o(257832);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257832);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ctz localctz = (ctz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257832);
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
            localctz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257832);
          return 0;
        case 2: 
          localctz.uxInfo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257832);
          return 0;
        case 3: 
          localctz.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257832);
          return 0;
        case 4: 
          localctz.YEv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257832);
          return 0;
        case 5: 
          localctz.YEY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257832);
          return 0;
        }
        localctz.extInfo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257832);
        return 0;
      }
      AppMethodBeat.o(257832);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctz
 * JD-Core Version:    0.7.0.1
 */