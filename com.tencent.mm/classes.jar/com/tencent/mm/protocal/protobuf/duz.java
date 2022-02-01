package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class duz
  extends erp
{
  public String ADE;
  public int YHt;
  public String abaO;
  public int abaR;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82460);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abaO != null) {
        paramVarArgs.g(2, this.abaO);
      }
      if (this.ADE != null) {
        paramVarArgs.g(3, this.ADE);
      }
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bS(5, this.abaR);
      paramVarArgs.bS(6, this.YHt);
      AppMethodBeat.o(82460);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label544;
      }
    }
    label544:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abaO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abaO);
      }
      i = paramInt;
      if (this.ADE != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ADE);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.scene);
      int j = i.a.a.b.b.a.cJ(5, this.abaR);
      int k = i.a.a.b.b.a.cJ(6, this.YHt);
      AppMethodBeat.o(82460);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82460);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        duz localduz = (duz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82460);
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
            localduz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82460);
          return 0;
        case 2: 
          localduz.abaO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82460);
          return 0;
        case 3: 
          localduz.ADE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82460);
          return 0;
        case 4: 
          localduz.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82460);
          return 0;
        case 5: 
          localduz.abaR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82460);
          return 0;
        }
        localduz.YHt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82460);
        return 0;
      }
      AppMethodBeat.o(82460);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duz
 * JD-Core Version:    0.7.0.1
 */