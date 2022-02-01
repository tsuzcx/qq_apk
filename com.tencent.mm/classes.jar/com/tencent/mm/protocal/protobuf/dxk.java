package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxk
  extends dyl
{
  public String RUd;
  public LinkedList<String> Tek;
  public dxe UcU;
  public dyc UcV;
  public int rWu;
  
  public dxk()
  {
    AppMethodBeat.i(115964);
    this.Tek = new LinkedList();
    AppMethodBeat.o(115964);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115965);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rWu);
      if (this.UcU != null)
      {
        paramVarArgs.oE(3, this.UcU.computeSize());
        this.UcU.writeFields(paramVarArgs);
      }
      if (this.UcV != null)
      {
        paramVarArgs.oE(4, this.UcV.computeSize());
        this.UcV.writeFields(paramVarArgs);
      }
      if (this.RUd != null) {
        paramVarArgs.f(5, this.RUd);
      }
      paramVarArgs.e(6, 1, this.Tek);
      AppMethodBeat.o(115965);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.rWu);
      paramInt = i;
      if (this.UcU != null) {
        paramInt = i + g.a.a.a.oD(3, this.UcU.computeSize());
      }
      i = paramInt;
      if (this.UcV != null) {
        i = paramInt + g.a.a.a.oD(4, this.UcV.computeSize());
      }
      paramInt = i;
      if (this.RUd != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RUd);
      }
      i = g.a.a.a.c(6, 1, this.Tek);
      AppMethodBeat.o(115965);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tek.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(115965);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxk localdxk = (dxk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115965);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdxk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 2: 
          localdxk.rWu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115965);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dxe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dxe)localObject2).parseFrom((byte[])localObject1);
            }
            localdxk.UcU = ((dxe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyc)localObject2).parseFrom((byte[])localObject1);
            }
            localdxk.UcV = ((dyc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115965);
          return 0;
        case 5: 
          localdxk.RUd = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(115965);
          return 0;
        }
        localdxk.Tek.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(115965);
        return 0;
      }
      AppMethodBeat.o(115965);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxk
 * JD-Core Version:    0.7.0.1
 */