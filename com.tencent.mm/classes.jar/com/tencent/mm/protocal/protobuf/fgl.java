package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fgl
  extends erp
{
  public int aamt;
  public int abGn;
  public String abGp;
  public String abdA;
  public String hOg;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91698);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abdA != null) {
        paramVarArgs.g(2, this.abdA);
      }
      if (this.signature != null) {
        paramVarArgs.g(3, this.signature);
      }
      if (this.abGp != null) {
        paramVarArgs.g(4, this.abGp);
      }
      if (this.hOg != null) {
        paramVarArgs.g(5, this.hOg);
      }
      paramVarArgs.bS(6, this.abGn);
      paramVarArgs.bS(7, this.aamt);
      AppMethodBeat.o(91698);
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
      if (this.abdA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abdA);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.signature);
      }
      paramInt = i;
      if (this.abGp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abGp);
      }
      i = paramInt;
      if (this.hOg != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hOg);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.abGn);
      int j = i.a.a.b.b.a.cJ(7, this.aamt);
      AppMethodBeat.o(91698);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fgl localfgl = (fgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91698);
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
            localfgl.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91698);
          return 0;
        case 2: 
          localfgl.abdA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 3: 
          localfgl.signature = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 4: 
          localfgl.abGp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 5: 
          localfgl.hOg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91698);
          return 0;
        case 6: 
          localfgl.abGn = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91698);
          return 0;
        }
        localfgl.aamt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91698);
        return 0;
      }
      AppMethodBeat.o(91698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fgl
 * JD-Core Version:    0.7.0.1
 */