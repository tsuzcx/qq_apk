package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhl
  extends com.tencent.mm.bx.a
{
  public String aaMJ;
  public String aaMK;
  public ful aaML;
  public String aaMM;
  public String aaMN;
  public String aaMO;
  public String aaMP;
  public String desc;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257626);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.g(1, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.aaMJ != null) {
        paramVarArgs.g(3, this.aaMJ);
      }
      if (this.aaMK != null) {
        paramVarArgs.g(4, this.aaMK);
      }
      if (this.aaML != null)
      {
        paramVarArgs.qD(5, this.aaML.computeSize());
        this.aaML.writeFields(paramVarArgs);
      }
      if (this.aaMM != null) {
        paramVarArgs.g(6, this.aaMM);
      }
      if (this.aaMN != null) {
        paramVarArgs.g(7, this.aaMN);
      }
      if (this.aaMO != null) {
        paramVarArgs.g(8, this.aaMO);
      }
      if (this.aaMP != null) {
        paramVarArgs.g(9, this.aaMP);
      }
      AppMethodBeat.o(257626);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label772;
      }
    }
    label772:
    for (int i = i.a.a.b.b.a.h(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.aaMJ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaMJ);
      }
      paramInt = i;
      if (this.aaMK != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaMK);
      }
      i = paramInt;
      if (this.aaML != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaML.computeSize());
      }
      paramInt = i;
      if (this.aaMM != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaMM);
      }
      i = paramInt;
      if (this.aaMN != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaMN);
      }
      paramInt = i;
      if (this.aaMO != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaMO);
      }
      i = paramInt;
      if (this.aaMP != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaMP);
      }
      AppMethodBeat.o(257626);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257626);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dhl localdhl = (dhl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257626);
          return -1;
        case 1: 
          localdhl.name = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 2: 
          localdhl.desc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 3: 
          localdhl.aaMJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 4: 
          localdhl.aaMK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ful localful = new ful();
            if ((localObject != null) && (localObject.length > 0)) {
              localful.parseFrom((byte[])localObject);
            }
            localdhl.aaML = localful;
            paramInt += 1;
          }
          AppMethodBeat.o(257626);
          return 0;
        case 6: 
          localdhl.aaMM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 7: 
          localdhl.aaMN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        case 8: 
          localdhl.aaMO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257626);
          return 0;
        }
        localdhl.aaMP = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257626);
        return 0;
      }
      AppMethodBeat.o(257626);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhl
 * JD-Core Version:    0.7.0.1
 */