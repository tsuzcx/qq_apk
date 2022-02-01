package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aes
  extends dyl
{
  public String CMP;
  public String Srf;
  public String Srg;
  public cqg Srh;
  public LinkedList<eaf> Sri;
  public String Srj;
  public String Srk;
  public int rVx;
  
  public aes()
  {
    AppMethodBeat.i(32181);
    this.Sri = new LinkedList();
    AppMethodBeat.o(32181);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32182);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Srh == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(32182);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CMP != null) {
        paramVarArgs.f(2, this.CMP);
      }
      if (this.Srf != null) {
        paramVarArgs.f(3, this.Srf);
      }
      if (this.Srg != null) {
        paramVarArgs.f(4, this.Srg);
      }
      if (this.Srh != null)
      {
        paramVarArgs.oE(5, this.Srh.computeSize());
        this.Srh.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.rVx);
      paramVarArgs.e(7, 8, this.Sri);
      if (this.Srj != null) {
        paramVarArgs.f(8, this.Srj);
      }
      if (this.Srk != null) {
        paramVarArgs.f(9, this.Srk);
      }
      AppMethodBeat.o(32182);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label955;
      }
    }
    label955:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CMP != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.CMP);
      }
      i = paramInt;
      if (this.Srf != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Srf);
      }
      paramInt = i;
      if (this.Srg != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Srg);
      }
      i = paramInt;
      if (this.Srh != null) {
        i = paramInt + g.a.a.a.oD(5, this.Srh.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(6, this.rVx) + g.a.a.a.c(7, 8, this.Sri);
      paramInt = i;
      if (this.Srj != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Srj);
      }
      i = paramInt;
      if (this.Srk != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Srk);
      }
      AppMethodBeat.o(32182);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Sri.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.Srh == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(32182);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32182);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aes localaes = (aes)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32182);
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
            localaes.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 2: 
          localaes.CMP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 3: 
          localaes.Srf = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 4: 
          localaes.Srg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32182);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqg)localObject2).parseFrom((byte[])localObject1);
            }
            localaes.Srh = ((cqg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 6: 
          localaes.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32182);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            localaes.Sri.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32182);
          return 0;
        case 8: 
          localaes.Srj = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32182);
          return 0;
        }
        localaes.Srk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32182);
        return 0;
      }
      AppMethodBeat.o(32182);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aes
 * JD-Core Version:    0.7.0.1
 */