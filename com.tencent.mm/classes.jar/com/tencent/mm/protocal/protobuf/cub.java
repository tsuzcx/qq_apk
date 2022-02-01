package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cub
  extends erp
{
  public int YAN;
  public String YEY;
  public String aazB;
  public String iaI;
  public String mdG;
  public int scene;
  public int tNW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257759);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mdG != null) {
        paramVarArgs.g(2, this.mdG);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.iaI != null) {
        paramVarArgs.g(4, this.iaI);
      }
      paramVarArgs.bS(5, this.tNW);
      if (this.aazB != null) {
        paramVarArgs.g(6, this.aazB);
      }
      if (this.YEY != null) {
        paramVarArgs.g(7, this.YEY);
      }
      paramVarArgs.bS(8, this.YAN);
      AppMethodBeat.o(257759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label664;
      }
    }
    label664:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.mdG);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.iaI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.tNW);
      paramInt = i;
      if (this.aazB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aazB);
      }
      i = paramInt;
      if (this.YEY != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YEY);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.YAN);
      AppMethodBeat.o(257759);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257759);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cub localcub = (cub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257759);
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
            localcub.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257759);
          return 0;
        case 2: 
          localcub.mdG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257759);
          return 0;
        case 3: 
          localcub.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257759);
          return 0;
        case 4: 
          localcub.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257759);
          return 0;
        case 5: 
          localcub.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257759);
          return 0;
        case 6: 
          localcub.aazB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257759);
          return 0;
        case 7: 
          localcub.YEY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257759);
          return 0;
        }
        localcub.YAN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257759);
        return 0;
      }
      AppMethodBeat.o(257759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cub
 * JD-Core Version:    0.7.0.1
 */