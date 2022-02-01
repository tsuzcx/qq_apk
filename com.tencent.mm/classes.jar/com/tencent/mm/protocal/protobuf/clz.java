package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clz
  extends com.tencent.mm.cd.a
{
  public String TtL;
  public String TtM;
  public ahi TtN;
  public ahi TtO;
  public String TtP;
  public String TtQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72509);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TtL != null) {
        paramVarArgs.f(1, this.TtL);
      }
      if (this.TtM != null) {
        paramVarArgs.f(2, this.TtM);
      }
      if (this.TtN != null)
      {
        paramVarArgs.oE(3, this.TtN.computeSize());
        this.TtN.writeFields(paramVarArgs);
      }
      if (this.TtO != null)
      {
        paramVarArgs.oE(4, this.TtO.computeSize());
        this.TtO.writeFields(paramVarArgs);
      }
      if (this.TtP != null) {
        paramVarArgs.f(5, this.TtP);
      }
      if (this.TtQ != null) {
        paramVarArgs.f(6, this.TtQ);
      }
      AppMethodBeat.o(72509);
      return 0;
    }
    if (paramInt == 1) {
      if (this.TtL == null) {
        break label662;
      }
    }
    label662:
    for (int i = g.a.a.b.b.a.g(1, this.TtL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TtM != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TtM);
      }
      i = paramInt;
      if (this.TtN != null) {
        i = paramInt + g.a.a.a.oD(3, this.TtN.computeSize());
      }
      paramInt = i;
      if (this.TtO != null) {
        paramInt = i + g.a.a.a.oD(4, this.TtO.computeSize());
      }
      i = paramInt;
      if (this.TtP != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TtP);
      }
      paramInt = i;
      if (this.TtQ != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TtQ);
      }
      AppMethodBeat.o(72509);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72509);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        clz localclz = (clz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        ahi localahi;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72509);
          return -1;
        case 1: 
          localclz.TtL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 2: 
          localclz.TtM = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72509);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localahi = new ahi();
            if ((localObject != null) && (localObject.length > 0)) {
              localahi.parseFrom((byte[])localObject);
            }
            localclz.TtN = localahi;
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localahi = new ahi();
            if ((localObject != null) && (localObject.length > 0)) {
              localahi.parseFrom((byte[])localObject);
            }
            localclz.TtO = localahi;
            paramInt += 1;
          }
          AppMethodBeat.o(72509);
          return 0;
        case 5: 
          localclz.TtP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(72509);
          return 0;
        }
        localclz.TtQ = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(72509);
        return 0;
      }
      AppMethodBeat.o(72509);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clz
 * JD-Core Version:    0.7.0.1
 */