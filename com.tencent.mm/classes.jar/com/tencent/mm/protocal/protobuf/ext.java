package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ext
  extends erp
{
  public String IGU;
  public String IHO;
  public String MpP;
  public String abzu;
  public String abzv;
  public String crB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155459);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.IHO != null) {
        paramVarArgs.g(2, this.IHO);
      }
      if (this.abzu != null) {
        paramVarArgs.g(3, this.abzu);
      }
      if (this.MpP != null) {
        paramVarArgs.g(5, this.MpP);
      }
      if (this.IGU != null) {
        paramVarArgs.g(4, this.IGU);
      }
      if (this.crB != null) {
        paramVarArgs.g(6, this.crB);
      }
      if (this.abzv != null) {
        paramVarArgs.g(7, this.abzv);
      }
      AppMethodBeat.o(155459);
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
      if (this.IHO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHO);
      }
      i = paramInt;
      if (this.abzu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abzu);
      }
      paramInt = i;
      if (this.MpP != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.MpP);
      }
      i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.IGU);
      }
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.crB);
      }
      i = paramInt;
      if (this.abzv != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abzv);
      }
      AppMethodBeat.o(155459);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ext localext = (ext)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155459);
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
            localext.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(155459);
          return 0;
        case 2: 
          localext.IHO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 3: 
          localext.abzu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 5: 
          localext.MpP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 4: 
          localext.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155459);
          return 0;
        case 6: 
          localext.crB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155459);
          return 0;
        }
        localext.abzv = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155459);
        return 0;
      }
      AppMethodBeat.o(155459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ext
 * JD-Core Version:    0.7.0.1
 */