package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fqh
  extends erp
{
  public dcy abQc;
  public LinkedList<ez> abQd;
  public eus abQe;
  public String link;
  public int scene;
  
  public fqh()
  {
    AppMethodBeat.i(152712);
    this.abQd = new LinkedList();
    AppMethodBeat.o(152712);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152713);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.link != null) {
        paramVarArgs.g(2, this.link);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.abQc != null)
      {
        paramVarArgs.qD(4, this.abQc.computeSize());
        this.abQc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.abQd);
      if (this.abQe != null)
      {
        paramVarArgs.qD(10, this.abQe.computeSize());
        this.abQe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152713);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.link != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.link);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.abQc != null) {
        paramInt = i + i.a.a.a.qC(4, this.abQc.computeSize());
      }
      i = paramInt + i.a.a.a.c(5, 8, this.abQd);
      paramInt = i;
      if (this.abQe != null) {
        paramInt = i + i.a.a.a.qC(10, this.abQe.computeSize());
      }
      AppMethodBeat.o(152713);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abQd.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fqh localfqh = (fqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(152713);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localfqh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 2: 
          localfqh.link = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152713);
          return 0;
        case 3: 
          localfqh.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152713);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dcy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dcy)localObject2).parseFrom((byte[])localObject1);
            }
            localfqh.abQc = ((dcy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ez();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ez)localObject2).parseFrom((byte[])localObject1);
            }
            localfqh.abQd.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152713);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eus)localObject2).parseFrom((byte[])localObject1);
          }
          localfqh.abQe = ((eus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152713);
        return 0;
      }
      AppMethodBeat.o(152713);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqh
 * JD-Core Version:    0.7.0.1
 */