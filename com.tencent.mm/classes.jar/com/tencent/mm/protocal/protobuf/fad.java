package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fad
  extends erp
{
  public String MDt;
  public String abAE;
  public String abAF;
  public int abAG;
  public int abAH;
  public int abAI;
  public String hAk;
  public String sign;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259874);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abAE != null) {
        paramVarArgs.g(2, this.abAE);
      }
      if (this.abAF != null) {
        paramVarArgs.g(3, this.abAF);
      }
      if (this.sign != null) {
        paramVarArgs.g(4, this.sign);
      }
      if (this.MDt != null) {
        paramVarArgs.g(5, this.MDt);
      }
      if (this.hAk != null) {
        paramVarArgs.g(6, this.hAk);
      }
      paramVarArgs.bS(7, this.abAG);
      paramVarArgs.bS(8, this.abAH);
      paramVarArgs.bS(9, this.abAI);
      AppMethodBeat.o(259874);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label728;
      }
    }
    label728:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abAE != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abAE);
      }
      i = paramInt;
      if (this.abAF != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abAF);
      }
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.sign);
      }
      i = paramInt;
      if (this.MDt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.MDt);
      }
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hAk);
      }
      i = i.a.a.b.b.a.cJ(7, this.abAG);
      int j = i.a.a.b.b.a.cJ(8, this.abAH);
      int k = i.a.a.b.b.a.cJ(9, this.abAI);
      AppMethodBeat.o(259874);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259874);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fad localfad = (fad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259874);
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
            localfad.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259874);
          return 0;
        case 2: 
          localfad.abAE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259874);
          return 0;
        case 3: 
          localfad.abAF = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259874);
          return 0;
        case 4: 
          localfad.sign = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259874);
          return 0;
        case 5: 
          localfad.MDt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259874);
          return 0;
        case 6: 
          localfad.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259874);
          return 0;
        case 7: 
          localfad.abAG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259874);
          return 0;
        case 8: 
          localfad.abAH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259874);
          return 0;
        }
        localfad.abAI = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259874);
        return 0;
      }
      AppMethodBeat.o(259874);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fad
 * JD-Core Version:    0.7.0.1
 */