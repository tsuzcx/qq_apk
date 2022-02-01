package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bbd
  extends com.tencent.mm.cd.a
{
  public int BpL;
  public b DgQ;
  public String SMN;
  public aza SMO;
  public String content;
  public String headUrl;
  public String ilo;
  public String nickname;
  public long seq;
  public int type;
  public String username;
  public aza zeL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231160);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.f(1, this.nickname);
      }
      if (this.headUrl != null) {
        paramVarArgs.f(2, this.headUrl);
      }
      if (this.content != null) {
        paramVarArgs.f(3, this.content);
      }
      paramVarArgs.aY(4, this.type);
      if (this.username != null) {
        paramVarArgs.f(5, this.username);
      }
      paramVarArgs.bm(6, this.seq);
      if (this.ilo != null) {
        paramVarArgs.f(7, this.ilo);
      }
      paramVarArgs.aY(8, this.BpL);
      if (this.zeL != null)
      {
        paramVarArgs.oE(9, this.zeL.computeSize());
        this.zeL.writeFields(paramVarArgs);
      }
      if (this.SMN != null) {
        paramVarArgs.f(10, this.SMN);
      }
      if (this.DgQ != null) {
        paramVarArgs.c(11, this.DgQ);
      }
      if (this.SMO != null)
      {
        paramVarArgs.oE(12, this.SMO.computeSize());
        this.SMO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(231160);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label986;
      }
    }
    label986:
    for (int i = g.a.a.b.b.a.g(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.headUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.headUrl);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.content);
      }
      i += g.a.a.b.b.a.bM(4, this.type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.username);
      }
      i = paramInt + g.a.a.b.b.a.p(6, this.seq);
      paramInt = i;
      if (this.ilo != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.ilo);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.BpL);
      paramInt = i;
      if (this.zeL != null) {
        paramInt = i + g.a.a.a.oD(9, this.zeL.computeSize());
      }
      i = paramInt;
      if (this.SMN != null) {
        i = paramInt + g.a.a.b.b.a.g(10, this.SMN);
      }
      paramInt = i;
      if (this.DgQ != null) {
        paramInt = i + g.a.a.b.b.a.b(11, this.DgQ);
      }
      i = paramInt;
      if (this.SMO != null) {
        i = paramInt + g.a.a.a.oD(12, this.SMO.computeSize());
      }
      AppMethodBeat.o(231160);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231160);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bbd localbbd = (bbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        aza localaza;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231160);
          return -1;
        case 1: 
          localbbd.nickname = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 2: 
          localbbd.headUrl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 3: 
          localbbd.content = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 4: 
          localbbd.type = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231160);
          return 0;
        case 5: 
          localbbd.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 6: 
          localbbd.seq = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(231160);
          return 0;
        case 7: 
          localbbd.ilo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 8: 
          localbbd.BpL = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(231160);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localaza = new aza();
            if ((localObject != null) && (localObject.length > 0)) {
              localaza.parseFrom((byte[])localObject);
            }
            localbbd.zeL = localaza;
            paramInt += 1;
          }
          AppMethodBeat.o(231160);
          return 0;
        case 10: 
          localbbd.SMN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(231160);
          return 0;
        case 11: 
          localbbd.DgQ = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(231160);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localaza = new aza();
          if ((localObject != null) && (localObject.length > 0)) {
            localaza.parseFrom((byte[])localObject);
          }
          localbbd.SMO = localaza;
          paramInt += 1;
        }
        AppMethodBeat.o(231160);
        return 0;
      }
      AppMethodBeat.o(231160);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbd
 * JD-Core Version:    0.7.0.1
 */