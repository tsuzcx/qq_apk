package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abh
  extends com.tencent.mm.bx.a
{
  public dfc VXQ;
  public dfc VXR;
  public String YXz;
  public String ZjS;
  public int ZjT;
  public String title;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      if (this.VXQ != null)
      {
        paramVarArgs.qD(3, this.VXQ.computeSize());
        this.VXQ.writeFields(paramVarArgs);
      }
      if (this.VXR != null)
      {
        paramVarArgs.qD(4, this.VXR.computeSize());
        this.VXR.writeFields(paramVarArgs);
      }
      if (this.ZjS != null) {
        paramVarArgs.g(5, this.ZjS);
      }
      if (this.YXz != null) {
        paramVarArgs.g(6, this.YXz);
      }
      paramVarArgs.bS(7, this.ZjT);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label706;
      }
    }
    label706:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = paramInt;
      if (this.VXQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.VXQ.computeSize());
      }
      paramInt = i;
      if (this.VXR != null) {
        paramInt = i + i.a.a.a.qC(4, this.VXR.computeSize());
      }
      i = paramInt;
      if (this.ZjS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjS);
      }
      paramInt = i;
      if (this.YXz != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YXz);
      }
      i = i.a.a.b.b.a.cJ(7, this.ZjT);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abh localabh = (abh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dfc localdfc;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localabh.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localabh.wording = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfc = new dfc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfc.parseFrom((byte[])localObject);
            }
            localabh.VXQ = localdfc;
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfc = new dfc();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfc.parseFrom((byte[])localObject);
            }
            localabh.VXR = localdfc;
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localabh.ZjS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localabh.YXz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localabh.ZjT = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abh
 * JD-Core Version:    0.7.0.1
 */