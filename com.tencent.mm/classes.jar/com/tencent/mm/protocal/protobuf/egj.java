package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class egj
  extends com.tencent.mm.bw.a
{
  public LinkedList<aca> IDO;
  public int Ngq;
  public String dDv;
  public String dPI;
  public String hes;
  public int scene;
  public String sessionId;
  public String talker;
  public String title;
  public String url;
  public int vkj;
  
  public egj()
  {
    AppMethodBeat.i(190312);
    this.IDO = new LinkedList();
    AppMethodBeat.o(190312);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190313);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.hes != null) {
        paramVarArgs.e(1, this.hes);
      }
      if (this.sessionId != null) {
        paramVarArgs.e(2, this.sessionId);
      }
      paramVarArgs.aM(3, this.scene);
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.dPI != null) {
        paramVarArgs.e(5, this.dPI);
      }
      if (this.dDv != null) {
        paramVarArgs.e(6, this.dDv);
      }
      paramVarArgs.e(7, 8, this.IDO);
      if (this.title != null) {
        paramVarArgs.e(8, this.title);
      }
      if (this.talker != null) {
        paramVarArgs.e(9, this.talker);
      }
      paramVarArgs.aM(10, this.vkj);
      paramVarArgs.aM(11, this.Ngq);
      AppMethodBeat.o(190313);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hes == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = g.a.a.b.b.a.f(1, this.hes) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.sessionId);
      }
      i += g.a.a.b.b.a.bu(3, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.dPI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dPI);
      }
      paramInt = i;
      if (this.dDv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dDv);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.IDO);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.title);
      }
      i = paramInt;
      if (this.talker != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.talker);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.vkj);
      int j = g.a.a.b.b.a.bu(11, this.Ngq);
      AppMethodBeat.o(190313);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.IDO.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(190313);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        egj localegj = (egj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(190313);
          return -1;
        case 1: 
          localegj.hes = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 2: 
          localegj.sessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 3: 
          localegj.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(190313);
          return 0;
        case 4: 
          localegj.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 5: 
          localegj.dPI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 6: 
          localegj.dDv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aca();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localegj.IDO.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(190313);
          return 0;
        case 8: 
          localegj.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 9: 
          localegj.talker = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(190313);
          return 0;
        case 10: 
          localegj.vkj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(190313);
          return 0;
        }
        localegj.Ngq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(190313);
        return 0;
      }
      AppMethodBeat.o(190313);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egj
 * JD-Core Version:    0.7.0.1
 */