package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class efh
  extends com.tencent.mm.bx.a
{
  public int abkD;
  public aey abkE;
  public tj abkF;
  public tj abkG;
  public String abkH;
  public String abkI;
  public String abkJ;
  public String desc;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259647);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.abkD);
      if (this.abkE != null)
      {
        paramVarArgs.qD(4, this.abkE.computeSize());
        this.abkE.writeFields(paramVarArgs);
      }
      if (this.abkF != null)
      {
        paramVarArgs.qD(5, this.abkF.computeSize());
        this.abkF.writeFields(paramVarArgs);
      }
      if (this.abkG != null)
      {
        paramVarArgs.qD(6, this.abkG.computeSize());
        this.abkG.writeFields(paramVarArgs);
      }
      if (this.abkH != null) {
        paramVarArgs.g(7, this.abkH);
      }
      if (this.abkI != null) {
        paramVarArgs.g(8, this.abkI);
      }
      if (this.abkJ != null) {
        paramVarArgs.g(9, this.abkJ);
      }
      AppMethodBeat.o(259647);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label900;
      }
    }
    label900:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.b.b.a.cJ(3, this.abkD);
      paramInt = i;
      if (this.abkE != null) {
        paramInt = i + i.a.a.a.qC(4, this.abkE.computeSize());
      }
      i = paramInt;
      if (this.abkF != null) {
        i = paramInt + i.a.a.a.qC(5, this.abkF.computeSize());
      }
      paramInt = i;
      if (this.abkG != null) {
        paramInt = i + i.a.a.a.qC(6, this.abkG.computeSize());
      }
      i = paramInt;
      if (this.abkH != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abkH);
      }
      paramInt = i;
      if (this.abkI != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abkI);
      }
      i = paramInt;
      if (this.abkJ != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abkJ);
      }
      AppMethodBeat.o(259647);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259647);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        efh localefh = (efh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259647);
          return -1;
        case 1: 
          localefh.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259647);
          return 0;
        case 2: 
          localefh.desc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259647);
          return 0;
        case 3: 
          localefh.abkD = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259647);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aey();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aey)localObject2).parseFrom((byte[])localObject1);
            }
            localefh.abkE = ((aey)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259647);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tj)localObject2).parseFrom((byte[])localObject1);
            }
            localefh.abkF = ((tj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259647);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tj)localObject2).parseFrom((byte[])localObject1);
            }
            localefh.abkG = ((tj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259647);
          return 0;
        case 7: 
          localefh.abkH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259647);
          return 0;
        case 8: 
          localefh.abkI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259647);
          return 0;
        }
        localefh.abkJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259647);
        return 0;
      }
      AppMethodBeat.o(259647);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efh
 * JD-Core Version:    0.7.0.1
 */