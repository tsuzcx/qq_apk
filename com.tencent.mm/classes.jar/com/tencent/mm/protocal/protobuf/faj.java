package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class faj
  extends erp
{
  public String IGU;
  public String Njp;
  public int aajL;
  public b abAK;
  public String abAL;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259752);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abAK != null) {
        paramVarArgs.d(2, this.abAK);
      }
      if (this.IGU != null) {
        paramVarArgs.g(3, this.IGU);
      }
      if (this.abAL != null) {
        paramVarArgs.g(4, this.abAL);
      }
      paramVarArgs.bS(5, this.vhJ);
      if (this.Njp != null) {
        paramVarArgs.g(6, this.Njp);
      }
      paramVarArgs.bS(7, this.aajL);
      AppMethodBeat.o(259752);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label616;
      }
    }
    label616:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abAK != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.abAK);
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGU);
      }
      paramInt = i;
      if (this.abAL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abAL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.vhJ);
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Njp);
      }
      i = i.a.a.b.b.a.cJ(7, this.aajL);
      AppMethodBeat.o(259752);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259752);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        faj localfaj = (faj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259752);
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
            localfaj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259752);
          return 0;
        case 2: 
          localfaj.abAK = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(259752);
          return 0;
        case 3: 
          localfaj.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259752);
          return 0;
        case 4: 
          localfaj.abAL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259752);
          return 0;
        case 5: 
          localfaj.vhJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259752);
          return 0;
        case 6: 
          localfaj.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259752);
          return 0;
        }
        localfaj.aajL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259752);
        return 0;
      }
      AppMethodBeat.o(259752);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faj
 * JD-Core Version:    0.7.0.1
 */