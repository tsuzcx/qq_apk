package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqf
  extends dyl
{
  public String SDA;
  public aqe SDi;
  public LinkedList<bgf> SDx;
  public int SDy;
  public int SDz;
  public String finderUsername;
  public String jDL;
  public int scene;
  
  public aqf()
  {
    AppMethodBeat.i(204119);
    this.SDx = new LinkedList();
    AppMethodBeat.o(204119);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(204121);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SDi != null)
      {
        paramVarArgs.oE(2, this.SDi.computeSize());
        this.SDi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.SDx);
      paramVarArgs.aY(4, this.scene);
      paramVarArgs.aY(5, this.SDy);
      paramVarArgs.aY(6, this.SDz);
      if (this.finderUsername != null) {
        paramVarArgs.f(7, this.finderUsername);
      }
      if (this.SDA != null) {
        paramVarArgs.f(8, this.SDA);
      }
      if (this.jDL != null) {
        paramVarArgs.f(9, this.jDL);
      }
      AppMethodBeat.o(204121);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label852;
      }
    }
    label852:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SDi != null) {
        i = paramInt + g.a.a.a.oD(2, this.SDi.computeSize());
      }
      i = i + g.a.a.a.c(3, 8, this.SDx) + g.a.a.b.b.a.bM(4, this.scene) + g.a.a.b.b.a.bM(5, this.SDy) + g.a.a.b.b.a.bM(6, this.SDz);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.finderUsername);
      }
      i = paramInt;
      if (this.SDA != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.SDA);
      }
      paramInt = i;
      if (this.jDL != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.jDL);
      }
      AppMethodBeat.o(204121);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SDx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(204121);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqf localaqf = (aqf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(204121);
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
            localaqf.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204121);
          return 0;
        case 2: 
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
            localaqf.SDi = ((aqe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204121);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bgf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bgf)localObject2).parseFrom((byte[])localObject1);
            }
            localaqf.SDx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(204121);
          return 0;
        case 4: 
          localaqf.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204121);
          return 0;
        case 5: 
          localaqf.SDy = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204121);
          return 0;
        case 6: 
          localaqf.SDz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(204121);
          return 0;
        case 7: 
          localaqf.finderUsername = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204121);
          return 0;
        case 8: 
          localaqf.SDA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(204121);
          return 0;
        }
        localaqf.jDL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(204121);
        return 0;
      }
      AppMethodBeat.o(204121);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqf
 * JD-Core Version:    0.7.0.1
 */