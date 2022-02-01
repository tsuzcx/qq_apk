package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egs
  extends erp
{
  public String IMu;
  public int MFe;
  public String ProductID;
  public String ablY;
  public String ablZ;
  public int abma;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91630);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(2, this.ProductID);
      }
      if (this.ablY != null) {
        paramVarArgs.g(3, this.ablY);
      }
      if (this.ablZ != null) {
        paramVarArgs.g(4, this.ablZ);
      }
      paramVarArgs.bS(5, this.MFe);
      if (this.IMu != null) {
        paramVarArgs.g(7, this.IMu);
      }
      paramVarArgs.bS(8, this.abma);
      AppMethodBeat.o(91630);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label620;
      }
    }
    label620:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ProductID);
      }
      i = paramInt;
      if (this.ablY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ablY);
      }
      paramInt = i;
      if (this.ablZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ablZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.MFe);
      paramInt = i;
      if (this.IMu != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.IMu);
      }
      i = i.a.a.b.b.a.cJ(8, this.abma);
      AppMethodBeat.o(91630);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91630);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        egs localegs = (egs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(91630);
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
            localegs.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91630);
          return 0;
        case 2: 
          localegs.ProductID = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 3: 
          localegs.ablY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 4: 
          localegs.ablZ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91630);
          return 0;
        case 5: 
          localegs.MFe = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91630);
          return 0;
        case 7: 
          localegs.IMu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91630);
          return 0;
        }
        localegs.abma = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91630);
        return 0;
      }
      AppMethodBeat.o(91630);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egs
 * JD-Core Version:    0.7.0.1
 */