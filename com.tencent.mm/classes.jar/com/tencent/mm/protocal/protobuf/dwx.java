package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dwx
  extends erp
{
  public String VxX;
  public String YNI;
  public String YNJ;
  public boolean abcI;
  public String abcJ;
  public String abcK;
  public int abcL;
  public String abcM;
  public String hAk;
  public int hUn;
  public int iaK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72530);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YNI != null) {
        paramVarArgs.g(2, this.YNI);
      }
      if (this.YNJ != null) {
        paramVarArgs.g(3, this.YNJ);
      }
      if (this.abcJ != null) {
        paramVarArgs.g(4, this.abcJ);
      }
      if (this.abcK != null) {
        paramVarArgs.g(5, this.abcK);
      }
      if (this.VxX != null) {
        paramVarArgs.g(6, this.VxX);
      }
      if (this.hAk != null) {
        paramVarArgs.g(7, this.hAk);
      }
      paramVarArgs.bS(8, this.hUn);
      paramVarArgs.bS(9, this.abcL);
      paramVarArgs.di(10, this.abcI);
      paramVarArgs.bS(11, this.iaK);
      if (this.abcM != null) {
        paramVarArgs.g(12, this.abcM);
      }
      AppMethodBeat.o(72530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label888;
      }
    }
    label888:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YNI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YNI);
      }
      i = paramInt;
      if (this.YNJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YNJ);
      }
      paramInt = i;
      if (this.abcJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abcJ);
      }
      i = paramInt;
      if (this.abcK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abcK);
      }
      paramInt = i;
      if (this.VxX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.VxX);
      }
      i = paramInt;
      if (this.hAk != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hAk);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.hUn) + i.a.a.b.b.a.cJ(9, this.abcL) + (i.a.a.b.b.a.ko(10) + 1) + i.a.a.b.b.a.cJ(11, this.iaK);
      paramInt = i;
      if (this.abcM != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abcM);
      }
      AppMethodBeat.o(72530);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72530);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dwx localdwx = (dwx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72530);
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
            localdwx.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72530);
          return 0;
        case 2: 
          localdwx.YNI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 3: 
          localdwx.YNJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 4: 
          localdwx.abcJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 5: 
          localdwx.abcK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 6: 
          localdwx.VxX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 7: 
          localdwx.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72530);
          return 0;
        case 8: 
          localdwx.hUn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72530);
          return 0;
        case 9: 
          localdwx.abcL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72530);
          return 0;
        case 10: 
          localdwx.abcI = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(72530);
          return 0;
        case 11: 
          localdwx.iaK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72530);
          return 0;
        }
        localdwx.abcM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72530);
        return 0;
      }
      AppMethodBeat.o(72530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */