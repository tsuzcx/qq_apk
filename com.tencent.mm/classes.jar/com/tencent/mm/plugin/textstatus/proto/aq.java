package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aq
  extends com.tencent.mm.bx.a
{
  public long TpM;
  public LinkedList<ao> TpN;
  public LinkedList<ao> TpO;
  public int TpP;
  public LinkedList<ao> TpQ;
  public String TpR;
  public String TpS;
  public int endTime;
  public String groupId;
  public int order;
  public String url;
  
  public aq()
  {
    AppMethodBeat.i(289985);
    this.TpN = new LinkedList();
    this.TpO = new LinkedList();
    this.TpQ = new LinkedList();
    AppMethodBeat.o(289985);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289994);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      paramVarArgs.bv(2, this.TpM);
      paramVarArgs.e(3, 8, this.TpN);
      paramVarArgs.e(4, 8, this.TpO);
      paramVarArgs.bS(5, this.TpP);
      paramVarArgs.bS(6, this.endTime);
      if (this.groupId != null) {
        paramVarArgs.g(7, this.groupId);
      }
      paramVarArgs.bS(8, this.order);
      paramVarArgs.e(9, 8, this.TpQ);
      if (this.TpR != null) {
        paramVarArgs.g(10, this.TpR);
      }
      if (this.TpS != null) {
        paramVarArgs.g(11, this.TpS);
      }
      AppMethodBeat.o(289994);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label924;
      }
    }
    label924:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.TpM) + i.a.a.a.c(3, 8, this.TpN) + i.a.a.a.c(4, 8, this.TpO) + i.a.a.b.b.a.cJ(5, this.TpP) + i.a.a.b.b.a.cJ(6, this.endTime);
      paramInt = i;
      if (this.groupId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.groupId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.order) + i.a.a.a.c(9, 8, this.TpQ);
      paramInt = i;
      if (this.TpR != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.TpR);
      }
      i = paramInt;
      if (this.TpS != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.TpS);
      }
      AppMethodBeat.o(289994);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TpN.clear();
        this.TpO.clear();
        this.TpQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289994);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aq localaq = (aq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        ao localao;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289994);
          return -1;
        case 1: 
          localaq.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289994);
          return 0;
        case 2: 
          localaq.TpM = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(289994);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localao = new ao();
            if ((localObject != null) && (localObject.length > 0)) {
              localao.parseFrom((byte[])localObject);
            }
            localaq.TpN.add(localao);
            paramInt += 1;
          }
          AppMethodBeat.o(289994);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localao = new ao();
            if ((localObject != null) && (localObject.length > 0)) {
              localao.parseFrom((byte[])localObject);
            }
            localaq.TpO.add(localao);
            paramInt += 1;
          }
          AppMethodBeat.o(289994);
          return 0;
        case 5: 
          localaq.TpP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289994);
          return 0;
        case 6: 
          localaq.endTime = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289994);
          return 0;
        case 7: 
          localaq.groupId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289994);
          return 0;
        case 8: 
          localaq.order = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289994);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localao = new ao();
            if ((localObject != null) && (localObject.length > 0)) {
              localao.parseFrom((byte[])localObject);
            }
            localaq.TpQ.add(localao);
            paramInt += 1;
          }
          AppMethodBeat.o(289994);
          return 0;
        case 10: 
          localaq.TpR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289994);
          return 0;
        }
        localaq.TpS = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(289994);
        return 0;
      }
      AppMethodBeat.o(289994);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.aq
 * JD-Core Version:    0.7.0.1
 */