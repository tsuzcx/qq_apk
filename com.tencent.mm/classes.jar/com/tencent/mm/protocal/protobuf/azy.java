package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class azy
  extends dyy
{
  public b RLO;
  public String SLt;
  public bln SLw;
  public bln SLx;
  public bdl SLy;
  public bln SLz;
  public LinkedList<bcr> SiG;
  public long klE;
  
  public azy()
  {
    AppMethodBeat.i(231218);
    this.SiG = new LinkedList();
    AppMethodBeat.o(231218);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(231221);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SiG);
      if (this.SLw != null)
      {
        paramVarArgs.oE(3, this.SLw.computeSize());
        this.SLw.writeFields(paramVarArgs);
      }
      if (this.RLO != null) {
        paramVarArgs.c(4, this.RLO);
      }
      if (this.SLx != null)
      {
        paramVarArgs.oE(5, this.SLx.computeSize());
        this.SLx.writeFields(paramVarArgs);
      }
      if (this.SLy != null)
      {
        paramVarArgs.oE(6, this.SLy.computeSize());
        this.SLy.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(7, this.klE);
      if (this.SLz != null)
      {
        paramVarArgs.oE(8, this.SLz.computeSize());
        this.SLz.writeFields(paramVarArgs);
      }
      if (this.SLt != null) {
        paramVarArgs.f(9, this.SLt);
      }
      AppMethodBeat.o(231221);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1106;
      }
    }
    label1106:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SiG);
      paramInt = i;
      if (this.SLw != null) {
        paramInt = i + g.a.a.a.oD(3, this.SLw.computeSize());
      }
      i = paramInt;
      if (this.RLO != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.RLO);
      }
      paramInt = i;
      if (this.SLx != null) {
        paramInt = i + g.a.a.a.oD(5, this.SLx.computeSize());
      }
      i = paramInt;
      if (this.SLy != null) {
        i = paramInt + g.a.a.a.oD(6, this.SLy.computeSize());
      }
      i += g.a.a.b.b.a.p(7, this.klE);
      paramInt = i;
      if (this.SLz != null) {
        paramInt = i + g.a.a.a.oD(8, this.SLz.computeSize());
      }
      i = paramInt;
      if (this.SLt != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.SLt);
      }
      AppMethodBeat.o(231221);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SiG.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(231221);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azy localazy = (azy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(231221);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bcr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bcr)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.SiG.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.SLw = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        case 4: 
          localazy.RLO = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(231221);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.SLx = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdl)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.SLy = ((bdl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        case 7: 
          localazy.klE = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(231221);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bln();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bln)localObject2).parseFrom((byte[])localObject1);
            }
            localazy.SLz = ((bln)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(231221);
          return 0;
        }
        localazy.SLt = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(231221);
        return 0;
      }
      AppMethodBeat.o(231221);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azy
 * JD-Core Version:    0.7.0.1
 */