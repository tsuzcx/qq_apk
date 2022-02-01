package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dud
  extends erp
{
  public int IJG;
  public int aaZE;
  public int aaZF;
  public b aaZG;
  public int aaZH;
  public String aaZI;
  public String aaZJ;
  public String aaZK;
  public b aauj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120957);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaZE);
      paramVarArgs.bS(3, this.aaZF);
      if (this.aaZG != null) {
        paramVarArgs.d(4, this.aaZG);
      }
      paramVarArgs.bS(5, this.aaZH);
      if (this.aauj != null) {
        paramVarArgs.d(6, this.aauj);
      }
      if (this.aaZI != null) {
        paramVarArgs.g(7, this.aaZI);
      }
      if (this.aaZJ != null) {
        paramVarArgs.g(8, this.aaZJ);
      }
      if (this.aaZK != null) {
        paramVarArgs.g(9, this.aaZK);
      }
      paramVarArgs.bS(10, this.IJG);
      AppMethodBeat.o(120957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label768;
      }
    }
    label768:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaZE) + i.a.a.b.b.a.cJ(3, this.aaZF);
      paramInt = i;
      if (this.aaZG != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.aaZG);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaZH);
      paramInt = i;
      if (this.aauj != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.aauj);
      }
      i = paramInt;
      if (this.aaZI != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaZI);
      }
      paramInt = i;
      if (this.aaZJ != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaZJ);
      }
      i = paramInt;
      if (this.aaZK != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaZK);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.IJG);
      AppMethodBeat.o(120957);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(120957);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dud localdud = (dud)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(120957);
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
            localdud.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(120957);
          return 0;
        case 2: 
          localdud.aaZE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(120957);
          return 0;
        case 3: 
          localdud.aaZF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(120957);
          return 0;
        case 4: 
          localdud.aaZG = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(120957);
          return 0;
        case 5: 
          localdud.aaZH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(120957);
          return 0;
        case 6: 
          localdud.aauj = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(120957);
          return 0;
        case 7: 
          localdud.aaZI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 8: 
          localdud.aaZJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(120957);
          return 0;
        case 9: 
          localdud.aaZK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(120957);
          return 0;
        }
        localdud.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(120957);
        return 0;
      }
      AppMethodBeat.o(120957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dud
 * JD-Core Version:    0.7.0.1
 */