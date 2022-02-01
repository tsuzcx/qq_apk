package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwb
  extends erp
{
  public int JaC;
  public String MDt;
  public int VaY;
  public String Vbl;
  public String abbN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91558);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.JaC);
      paramVarArgs.bS(3, this.VaY);
      if (this.MDt != null) {
        paramVarArgs.g(4, this.MDt);
      }
      if (this.abbN != null) {
        paramVarArgs.g(5, this.abbN);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91558);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.JaC) + i.a.a.b.b.a.cJ(3, this.VaY);
      paramInt = i;
      if (this.MDt != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MDt);
      }
      i = paramInt;
      if (this.abbN != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abbN);
      }
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91558);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dwb localdwb = (dwb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91558);
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
            localdwb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91558);
          return 0;
        case 2: 
          localdwb.JaC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91558);
          return 0;
        case 3: 
          localdwb.VaY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91558);
          return 0;
        case 4: 
          localdwb.MDt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91558);
          return 0;
        case 5: 
          localdwb.abbN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91558);
          return 0;
        }
        localdwb.Vbl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91558);
        return 0;
      }
      AppMethodBeat.o(91558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwb
 * JD-Core Version:    0.7.0.1
 */