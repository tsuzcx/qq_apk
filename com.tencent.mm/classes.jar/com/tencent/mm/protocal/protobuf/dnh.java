package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnh
  extends com.tencent.mm.bx.a
{
  public String aaUC;
  public dnu aaUD;
  public dnl aaUE;
  public dnu aaUF;
  public String description;
  public LinkedList<dnv> media;
  public int mediaType;
  
  public dnh()
  {
    AppMethodBeat.i(258662);
    this.media = new LinkedList();
    AppMethodBeat.o(258662);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258668);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.description != null) {
        paramVarArgs.g(1, this.description);
      }
      paramVarArgs.e(2, 8, this.media);
      paramVarArgs.bS(3, this.mediaType);
      if (this.aaUC != null) {
        paramVarArgs.g(4, this.aaUC);
      }
      if (this.aaUD != null)
      {
        paramVarArgs.qD(5, this.aaUD.computeSize());
        this.aaUD.writeFields(paramVarArgs);
      }
      if (this.aaUE != null)
      {
        paramVarArgs.qD(6, this.aaUE.computeSize());
        this.aaUE.writeFields(paramVarArgs);
      }
      if (this.aaUF != null)
      {
        paramVarArgs.qD(7, this.aaUF.computeSize());
        this.aaUF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258668);
      return 0;
    }
    if (paramInt == 1) {
      if (this.description == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = i.a.a.b.b.a.h(1, this.description) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.media) + i.a.a.b.b.a.cJ(3, this.mediaType);
      paramInt = i;
      if (this.aaUC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaUC);
      }
      i = paramInt;
      if (this.aaUD != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaUD.computeSize());
      }
      paramInt = i;
      if (this.aaUE != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaUE.computeSize());
      }
      i = paramInt;
      if (this.aaUF != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaUF.computeSize());
      }
      AppMethodBeat.o(258668);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.media.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258668);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnh localdnh = (dnh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258668);
          return -1;
        case 1: 
          localdnh.description = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258668);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnv)localObject2).parseFrom((byte[])localObject1);
            }
            localdnh.media.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258668);
          return 0;
        case 3: 
          localdnh.mediaType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258668);
          return 0;
        case 4: 
          localdnh.aaUC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258668);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnu)localObject2).parseFrom((byte[])localObject1);
            }
            localdnh.aaUD = ((dnu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258668);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dnl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dnl)localObject2).parseFrom((byte[])localObject1);
            }
            localdnh.aaUE = ((dnl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258668);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dnu();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dnu)localObject2).parseFrom((byte[])localObject1);
          }
          localdnh.aaUF = ((dnu)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258668);
        return 0;
      }
      AppMethodBeat.o(258668);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnh
 * JD-Core Version:    0.7.0.1
 */