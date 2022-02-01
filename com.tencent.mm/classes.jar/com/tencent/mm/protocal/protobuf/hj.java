package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hj
  extends com.tencent.mm.bx.a
{
  public dxf YIO;
  public LinkedList<dxf> YIP;
  public String hFb;
  public String hMM;
  
  public hj()
  {
    AppMethodBeat.i(152496);
    this.YIP = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hMM != null) {
        paramVarArgs.g(1, this.hMM);
      }
      if (this.YIO != null)
      {
        paramVarArgs.qD(2, this.YIO.computeSize());
        this.YIO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.YIP);
      if (this.hFb != null) {
        paramVarArgs.g(4, this.hFb);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hMM == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = i.a.a.b.b.a.h(1, this.hMM) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIO != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIO.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.YIP);
      paramInt = i;
      if (this.hFb != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hFb);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YIP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hj localhj = (hj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dxf localdxf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localhj.hMM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdxf = new dxf();
            if ((localObject != null) && (localObject.length > 0)) {
              localdxf.parseFrom((byte[])localObject);
            }
            localhj.YIO = localdxf;
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdxf = new dxf();
            if ((localObject != null) && (localObject.length > 0)) {
              localdxf.parseFrom((byte[])localObject);
            }
            localhj.YIP.add(localdxf);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localhj.hFb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hj
 * JD-Core Version:    0.7.0.1
 */