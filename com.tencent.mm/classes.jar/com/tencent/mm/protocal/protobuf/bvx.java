package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bvx
  extends dyl
{
  public int TfE;
  public LinkedList<adl> TfF;
  public int scene;
  public String version;
  public String wpG;
  public String wpH;
  
  public bvx()
  {
    AppMethodBeat.i(254330);
    this.TfF = new LinkedList();
    AppMethodBeat.o(254330);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(254331);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.wpG == null)
      {
        paramVarArgs = new b("Not all required fields were included: rversion");
        AppMethodBeat.o(254331);
        throw paramVarArgs;
      }
      if (this.wpH == null)
      {
        paramVarArgs = new b("Not all required fields were included: buildTag");
        AppMethodBeat.o(254331);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TfE);
      paramVarArgs.aY(3, this.scene);
      if (this.version != null) {
        paramVarArgs.f(4, this.version);
      }
      if (this.wpG != null) {
        paramVarArgs.f(5, this.wpG);
      }
      if (this.wpH != null) {
        paramVarArgs.f(6, this.wpH);
      }
      paramVarArgs.e(7, 8, this.TfF);
      AppMethodBeat.o(254331);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label774;
      }
    }
    label774:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TfE) + g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.version != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.version);
      }
      i = paramInt;
      if (this.wpG != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.wpG);
      }
      paramInt = i;
      if (this.wpH != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.wpH);
      }
      i = g.a.a.a.c(7, 8, this.TfF);
      AppMethodBeat.o(254331);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TfF.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.wpG == null)
        {
          paramVarArgs = new b("Not all required fields were included: rversion");
          AppMethodBeat.o(254331);
          throw paramVarArgs;
        }
        if (this.wpH == null)
        {
          paramVarArgs = new b("Not all required fields were included: buildTag");
          AppMethodBeat.o(254331);
          throw paramVarArgs;
        }
        AppMethodBeat.o(254331);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bvx localbvx = (bvx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(254331);
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
            localbvx.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(254331);
          return 0;
        case 2: 
          localbvx.TfE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(254331);
          return 0;
        case 3: 
          localbvx.scene = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(254331);
          return 0;
        case 4: 
          localbvx.version = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(254331);
          return 0;
        case 5: 
          localbvx.wpG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(254331);
          return 0;
        case 6: 
          localbvx.wpH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(254331);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new adl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((adl)localObject2).parseFrom((byte[])localObject1);
          }
          localbvx.TfF.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(254331);
        return 0;
      }
      AppMethodBeat.o(254331);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvx
 * JD-Core Version:    0.7.0.1
 */