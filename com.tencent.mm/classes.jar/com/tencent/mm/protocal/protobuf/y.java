package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class y
  extends erp
{
  public String YzL;
  public String YzM;
  public int scene;
  public String sign;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91333);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YzL != null) {
        paramVarArgs.g(2, this.YzL);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.YzM != null) {
        paramVarArgs.g(4, this.YzM);
      }
      if (this.sign != null) {
        paramVarArgs.g(5, this.sign);
      }
      paramVarArgs.bS(6, this.ver);
      AppMethodBeat.o(91333);
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
      int i = paramInt;
      if (this.YzL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YzL);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YzM);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.sign);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.ver);
      AppMethodBeat.o(91333);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        y localy = (y)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91333);
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
            localy.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91333);
          return 0;
        case 2: 
          localy.YzL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 3: 
          localy.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91333);
          return 0;
        case 4: 
          localy.YzM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91333);
          return 0;
        case 5: 
          localy.sign = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91333);
          return 0;
        }
        localy.ver = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91333);
        return 0;
      }
      AppMethodBeat.o(91333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.y
 * JD-Core Version:    0.7.0.1
 */