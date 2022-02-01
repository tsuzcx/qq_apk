package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bzm
  extends erp
{
  public String MFB;
  public String Njp;
  public String YOc;
  public String aaiH;
  public String aaiI;
  public String aaiJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91466);
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
      if (this.YOc != null) {
        paramVarArgs.g(3, this.YOc);
      }
      if (this.MFB != null) {
        paramVarArgs.g(4, this.MFB);
      }
      if (this.aaiI != null) {
        paramVarArgs.g(5, this.aaiI);
      }
      if (this.aaiJ != null) {
        paramVarArgs.g(6, this.aaiJ);
      }
      if (this.Njp != null) {
        paramVarArgs.g(7, this.Njp);
      }
      AppMethodBeat.o(91466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label648;
      }
    }
    label648:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaiH != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaiH);
      }
      i = paramInt;
      if (this.YOc != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YOc);
      }
      paramInt = i;
      if (this.MFB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MFB);
      }
      i = paramInt;
      if (this.aaiI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaiI);
      }
      paramInt = i;
      if (this.aaiJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaiJ);
      }
      i = paramInt;
      if (this.Njp != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Njp);
      }
      AppMethodBeat.o(91466);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91466);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bzm localbzm = (bzm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91466);
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
            localbzm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91466);
          return 0;
        case 2: 
          localbzm.aaiH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 3: 
          localbzm.YOc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 4: 
          localbzm.MFB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 5: 
          localbzm.aaiI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91466);
          return 0;
        case 6: 
          localbzm.aaiJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91466);
          return 0;
        }
        localbzm.Njp = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91466);
        return 0;
      }
      AppMethodBeat.o(91466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzm
 * JD-Core Version:    0.7.0.1
 */