package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fka
  extends erp
{
  public String Njp;
  public String aaiH;
  public String aaiI;
  public String aaiJ;
  public String aatQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91704);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaiH != null) {
        paramVarArgs.g(2, this.aaiH);
      }
      if (this.aatQ != null) {
        paramVarArgs.g(3, this.aatQ);
      }
      if (this.aaiI != null) {
        paramVarArgs.g(4, this.aaiI);
      }
      if (this.aaiJ != null) {
        paramVarArgs.g(5, this.aaiJ);
      }
      if (this.Njp != null) {
        paramVarArgs.g(6, this.Njp);
      }
      AppMethodBeat.o(91704);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaiH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaiH);
      }
      i = paramInt;
      if (this.aatQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aatQ);
      }
      paramInt = i;
      if (this.aaiI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaiI);
      }
      i = paramInt;
      if (this.aaiJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaiJ);
      }
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Njp);
      }
      AppMethodBeat.o(91704);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91704);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fka localfka = (fka)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91704);
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
            localfka.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91704);
          return 0;
        case 2: 
          localfka.aaiH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 3: 
          localfka.aatQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 4: 
          localfka.aaiI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91704);
          return 0;
        case 5: 
          localfka.aaiJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91704);
          return 0;
        }
        localfka.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91704);
        return 0;
      }
      AppMethodBeat.o(91704);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fka
 * JD-Core Version:    0.7.0.1
 */