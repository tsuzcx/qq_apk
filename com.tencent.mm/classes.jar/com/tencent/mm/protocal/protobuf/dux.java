package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dux
  extends erp
{
  public int ZqK;
  public String abaO;
  public int abaP;
  public LinkedList<String> abaQ;
  
  public dux()
  {
    AppMethodBeat.i(82457);
    this.abaQ = new LinkedList();
    AppMethodBeat.o(82457);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82458);
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
      paramVarArgs.bS(3, this.abaP);
      paramVarArgs.e(4, 1, this.abaQ);
      paramVarArgs.bS(5, this.ZqK);
      AppMethodBeat.o(82458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abaO != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abaO);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.abaP);
      int j = i.a.a.a.c(4, 1, this.abaQ);
      int k = i.a.a.b.b.a.cJ(5, this.ZqK);
      AppMethodBeat.o(82458);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abaQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(82458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dux localdux = (dux)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82458);
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
            localdux.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(82458);
          return 0;
        case 2: 
          localdux.abaO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82458);
          return 0;
        case 3: 
          localdux.abaP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(82458);
          return 0;
        case 4: 
          localdux.abaQ.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(82458);
          return 0;
        }
        localdux.ZqK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82458);
        return 0;
      }
      AppMethodBeat.o(82458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dux
 * JD-Core Version:    0.7.0.1
 */