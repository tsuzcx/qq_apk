package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class apq
  extends dyl
{
  public long JVf;
  public String RLN;
  public int SCV;
  public aqo SCW;
  public long SCX;
  public String firstPageMD5;
  public b lastBuffer;
  public String username;
  public int xbJ;
  public String xxK;
  public aqe yjp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200959);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.f(2, this.username);
      }
      paramVarArgs.bm(3, this.JVf);
      if (this.firstPageMD5 != null) {
        paramVarArgs.f(4, this.firstPageMD5);
      }
      if (this.RLN != null) {
        paramVarArgs.f(5, this.RLN);
      }
      paramVarArgs.aY(6, this.SCV);
      if (this.yjp != null)
      {
        paramVarArgs.oE(7, this.yjp.computeSize());
        this.yjp.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      paramVarArgs.aY(9, this.xbJ);
      if (this.SCW != null)
      {
        paramVarArgs.oE(10, this.SCW.computeSize());
        this.SCW.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(11, this.SCX);
      if (this.xxK != null) {
        paramVarArgs.f(12, this.xxK);
      }
      AppMethodBeat.o(200959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1044;
      }
    }
    label1044:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.username);
      }
      i += g.a.a.b.b.a.p(3, this.JVf);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.RLN != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RLN);
      }
      i += g.a.a.b.b.a.bM(6, this.SCV);
      paramInt = i;
      if (this.yjp != null) {
        paramInt = i + g.a.a.a.oD(7, this.yjp.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + g.a.a.b.b.a.b(8, this.lastBuffer);
      }
      i += g.a.a.b.b.a.bM(9, this.xbJ);
      paramInt = i;
      if (this.SCW != null) {
        paramInt = i + g.a.a.a.oD(10, this.SCW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.p(11, this.SCX);
      paramInt = i;
      if (this.xxK != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.xxK);
      }
      AppMethodBeat.o(200959);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(200959);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        apq localapq = (apq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200959);
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
            localapq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200959);
          return 0;
        case 2: 
          localapq.username = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(200959);
          return 0;
        case 3: 
          localapq.JVf = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(200959);
          return 0;
        case 4: 
          localapq.firstPageMD5 = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(200959);
          return 0;
        case 5: 
          localapq.RLN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(200959);
          return 0;
        case 6: 
          localapq.SCV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200959);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqe)localObject2).parseFrom((byte[])localObject1);
            }
            localapq.yjp = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200959);
          return 0;
        case 8: 
          localapq.lastBuffer = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(200959);
          return 0;
        case 9: 
          localapq.xbJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200959);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aqo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aqo)localObject2).parseFrom((byte[])localObject1);
            }
            localapq.SCW = ((aqo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200959);
          return 0;
        case 11: 
          localapq.SCX = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(200959);
          return 0;
        }
        localapq.xxK = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(200959);
        return 0;
      }
      AppMethodBeat.o(200959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apq
 * JD-Core Version:    0.7.0.1
 */