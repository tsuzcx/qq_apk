package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mm
  extends erp
{
  public String VJo;
  public String YNI;
  public String YNJ;
  public String YNK;
  public int hUn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72422);
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
      if (this.VJo != null) {
        paramVarArgs.g(4, this.VJo);
      }
      if (this.YNK != null) {
        paramVarArgs.g(5, this.YNK);
      }
      paramVarArgs.bS(7, this.hUn);
      AppMethodBeat.o(72422);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
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
      if (this.VJo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VJo);
      }
      i = paramInt;
      if (this.YNK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YNK);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.hUn);
      AppMethodBeat.o(72422);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72422);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        mm localmm = (mm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(72422);
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
            localmm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(72422);
          return 0;
        case 2: 
          localmm.YNI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 3: 
          localmm.YNJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 4: 
          localmm.VJo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72422);
          return 0;
        case 5: 
          localmm.YNK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72422);
          return 0;
        }
        localmm.hUn = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(72422);
        return 0;
      }
      AppMethodBeat.o(72422);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mm
 * JD-Core Version:    0.7.0.1
 */